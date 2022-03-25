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
        //dd($request);
        $input = $request->all();
        $validator = Validator::make($input,[
            "name" => "required",
            "calorievalue" => "required",
            "fat" => "required",
            "protein" => "required",
            "carbonhydrate" => "required",
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

    public function update(Request $request, Meal $meals){
        $input = $request -> all();
        $validator = validator::make($input,[
            "name" => "required",
            "calorievalue" => "required",
            "fat" => "required",
            "protein" => "required",
            "carbonhydrate" => "required",
            "salt" => "required",
        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }
        
        $meals -> name = $input["name"];
        $meals -> calorievalue = $input["calorievalue"];
        $meals -> fat = $input["fat"];
        $meals -> protein = $input["protein"];
        $meals -> carbonhydrate = $input["carbonhydrate"];
        $meals -> salt = $input["salt"];


        $meals -> save();

        return $this->sendResponse(new MealsResources($meals),"Adatok módosítva");
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