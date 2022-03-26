<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Validator;
use App\Models\User;
use App\Http\Controllers\API\Users;
 
use App\Http\Resources\user as UserResources;



class UserController extends BaseController
{

    public function storeUser(Request $request){
        //dd($request);
        $input = $request->all();
        $validator = Validator::make($input,[
            "name" => "required",
            "email" => "required",
            "password" => "required",



        ]);

        if($validator->fails()){
            return $this->sendError($validator->errors());
        }

        $user = User::create($input);

        return $this->sendResponse(new UserResources($user),"Felhasználó kiírva");
    }

    public function show($id){
        $user = User::find($id);
        if(is_null($user)){
            return $this->sendError("Nincs ilyen Felhasználó");
        }
        return $this->sendResponse(new UserResources($user),"Felhasználó adatai betöltve");
    }

    // public function showAll(){
    //     $user = User::all();
    //     if(is_null($user)){
    //         return $this->sendError("Nincs ilyen Felhasználó");
    //     }
    //     return $this->sendResponse(new UserResources($user),"Felhasználók adatai betöltve");
    // }


    public function showAll() {
        $user = User::all();
        return $this -> sendResponse(UserResources::collection($user),"Összes felhasználó");
    }

    // public function update(Request $request, User $user){
    //     $input = $request -> all();
    //     $validator = validator::make($input,[
    //         "name" => "required",
    //         "email" => "required",
    //         "password" => "required",


    //     ]);

    //     if($validator->fails()){
    //         return $this->sendError($validator->errors());
    //     }
        
    //     $user -> name = $input["name"];
    //     $user -> email = $input["email"];
    //     $user -> password = $input["password"];




    //     $user -> save();

    //     return $this->sendResponse(new UserResources($user),"Felhasználó adatai módosítva");
    // }


    public function destroy($id){
        User::destroy($id);
        return $this->sendResponse([],"Felhasználó törölve");
    }


    public function search($name){
        $result = User::where('name', 'LIKE', '%'. $name. '%')->get();
        if(count($result)){
            return Response()->json($result);
        }
        else
        {
            return response()->json(['Result' => 'Nincs talalat'], 404);
        }
    }
    
}