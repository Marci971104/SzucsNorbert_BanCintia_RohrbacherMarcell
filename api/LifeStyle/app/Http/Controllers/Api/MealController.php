<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Validator;
use App\Models\Meal;
use App\Http\Controllers\API\Meals;
 
use App\Http\Resources\meals as MealsResources;




class MealController extends BaseController
{

    public function store(Request $request){
        $input = $request->all();
        $validator = Validator::make($input,[
            "name" => "required",
            "calorievalue" => "required",
            "fat" => "required",
            "protein" => "required",
            "carbohydrate" => "required",
            "salt" => "required",
        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }

        $meals = Meal::create($input);

        return $this->sendResponse(new MealsResources($meals),"Étel kiírva");
    }

    public function show($id){
        $meals = Meal::find($id);
        if(is_null($meals)){
            return $this->sendError("Nincs ilyen étel");
        }
        return $this->sendResponse(new MealsResources($meals),"Étel betöltve");
    }

    public function showAll() {
        $meals = Meal::all();
        return $this -> sendResponse(MealsResources::collection($meals),"Összes étel");
    }

    public function update(Request $request, $id ) {
        $meal = Meal::find($id);
        if( is_null($meal)){
            return $this->sendError("Nincs ilyen adat");
        }
        $input = $request->all();
        $validator = Validator::make($input, [
            "name" => "required",
            "calorievalue" => "required",
            "fat" => "required",
            "protein" => "required",
            "carbohydrate" => "required",
            "salt" => "required",
        ]);
        if($validator->fails()){
            return $this->sendError($validator->errors());
        }

        try {

            $meal -> name = $input["name"];
            $meal-> calorievalue = $input["calorievalue"];
            $meal -> fat = $input["fat"];
            $meal -> protein = $input["protein"];
            $meal -> carbohydrate = $input["carbohydrate"];
            $meal -> salt = $input["salt"];
            $meal -> save();

            return $this->sendResponse(new MealsResources($meal), "Adatok módosítva");

        } catch (\Throwable $ex) {
            return $this->sendError("Hiba a kiírás során", $ex);
        }
    }

    public function destroy($id){
        Meal::destroy($id);
        return $this->sendResponse([],"Adatok törölve");
    }


    public function search($name){
        $result = Meal::where('name', 'LIKE', '%'. $name. '%')->get();
        if(count($result)){
            return Response()->json($result);
        }
        else
        {
            return response()->json(['Result' => 'Nincs talalat'], 404);
        }
    }
    
}