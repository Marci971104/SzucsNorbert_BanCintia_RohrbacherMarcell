<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Validator;
use App\Models\datas;
use App\Models\ingerdients;
use App\Models\meals;
use App\Models\Users;
use App\Http\Resources\datas as datasResources;
use App\Http\Resources\ingerdients as ingerdientsResources;
use App\Http\Resources\meals as mealsResources;
use App\Http\Resources\Users as UsersResources;
use Illuminate\Support\Facades\DB;

class LifestyleController extends BaseController
{

    public function store(Request $request){
        //dd($request);
        $input = $request->all();
        $validator = Validator::make($input,[
            "name" => "required",
            "price" => "required",
            "material_id" => "required"
        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }

        $products = Products::create($input);

        return $this->sendResponse(new ProductsResources($products),"Husi kiírva");
    }

    public function show($id){
        $products = Products::find($id);
        if(is_null($products)){
            return $this->sendError("Nincs ilyen husi");
        }
        return $this->sendResponse(new ProductsResources($products),"Husi betöltve");
    }

    public function update(Request $request, Products $products){
        $input = $request -> all();
        $validator = validator::make($input,[
            "name" => "required",
            "price" => "required",
            "material_id" => "required"
        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }
        
        $products -> name = $input["name"];
        $products -> price = $input["price"];
        $products -> material_id = $input["material_id"];
        $products -> save();

        return $this->sendResponse(new ProductsResources($products),"Adatok módosítva");
    }


    public function destroy($id){
        users::destroy($id);
        return $this->sendResponse([],"Adatok törölve");
    }


    public function search($name){
        $result = Products::where('name', 'LIKE', '%'. $name. '%')->get();
        if(count($result)){
            return Response()->json($result);
        }
        else
        {
            return response()->json(['Result' => 'Nincs talalat'], 404);
        }
    }
    public function materialsearch($material){
        $result = Material::where('material', 'LIKE', '%'. $material. '%')->join('products', 'materials.id', '=', 'products.material_id')->get();
        if(count($result)){
            return Response()->json($result);
        }
        else
        {
            return response()->json(['Result' => 'Nincs talalat'], 404);
        }
    }
}