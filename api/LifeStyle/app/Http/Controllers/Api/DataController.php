<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Validator;
use App\Models\Data;
use App\Http\Controllers\API\Datas;
 
use App\Http\Resources\data as DataResources;



class DataController extends BaseController
{

    public function storeData(Request $request){
        //dd($request);
        $input = $request->all();
        $validator = Validator::make($input,[
            "height" => "required",
            "weight" => "required",
            "age" => "required",
            "gender" => "required",



        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }

        $data = Data::create($input);

        return $this->sendResponse(new DataResources($data),"Adatok kiírva");
    }

    public function show($id){
        $data = Data::find($id);
        if(is_null($data)){
            return $this->sendError("Nincs ilyen adat");
        }
        return $this->sendResponse(new DataResources($data),"Adat betöltve");
    }

    public function showAll(){
        $data = Data::all();
        if(is_null($data)){
            return $this->sendError("Nincs ilyen adat");
        }
        return $this->sendResponse(new DataResources($data),"Adatok betöltve");
    }

    public function update(Request $request, Data $data){
        $input = $request -> all();
        $validator = validator::make($input,[
            "height" => "required",
            "weight" => "required",
            "age" => "required",
            "gender" => "required",

        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }
        
        $data -> height = $input["height"];
        $data -> weight = $input["weight"];
        $data -> age = $input["age"];
        $data -> gender = $input["gender"];



        $data -> save();

        return $this->sendResponse(new DataResources($data),"Adatok módosítva");
    }


    public function destroy($id){
        Data::destroy($id);
        return $this->sendResponse([],"Adatok törölve");
    }


    public function search($name){
        $result = Data::where('name', 'LIKE', '%'. $name. '%')->get();
        if(count($result)){
            return Response()->json($result);
        }
        else
        {
            return response()->json(['Result' => 'Nincs talalat'], 404);
        }
    }
    
}