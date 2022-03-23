<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Meal;

class MealController extends Controller
{
    public function index(){
        $meals= Meal::all();
        return view ("/list_meals",[
            "meals"=> $meals
        ]);

    }

    public function create(){
        return view("new_meal");
    }

    public function store(Request $request){    
        Meal::create($request->all());
        return redirect("/");    

    }

    public function edit($id){
        $meal= Meal::find($id);

        return view("edit_meals",[
            "meal" =>$meal
        ]);
    }

    public function update(Request $request){
        $meal= Meal::find($request->id);
        $meal->update($request->all());

        return redirect("/");
    }

    public function destroy($id){
        Meal::destroy($id);

        return redirect("/");
    }
}
