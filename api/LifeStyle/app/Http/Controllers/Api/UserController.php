<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Illuminate\Support\Facades\DB;
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


    // public function destroy($id){
    //     User::destroy($id);
    //     return $this->sendResponse([],"Felhasználó törölve");
    // }

    public function destroy($id = null){
        $user = auth("sanctum")->user();
        if(is_null($id)){
            $account = auth("sanctum")->user();
        }else{
            $account = User::find($id);
        }
        if(is_null($account)){
            return $this->sendError("Nincs ilyen felhasználó");
        }elseif($account->id == $user->id || $user->admin){
            if($account->admin){
                return $this->sendError("Az admin nem törölhető");
            }

            DB::table('personal_access_tokens')
                ->where('tokenable_id', '=', $account->id)
                ->delete();
            try {
                User::destroy($account->id);
                return $this->sendResponse([], "A felhasználó törölve");
            } catch (\Throwable $e) {
                return $this->sendError("Hiba a felhasználó törlése során", $e);
            }
        }else{
            return $this->sendError("Ez a fiók nem az öné ezért nem törölheti");
        }
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

    public function searchuser($username){
        if(auth( "sanctum" )->user()->admin){
            $users = DB::table('users')
                ->select('name', 'email', 'data_id', 'id')
                ->where('name', 'like', '%'.$name.'%')
                ->get();
            if(is_null($users)){
                return $this->sendError("Nincs találat a keresésre");
            }
            return $this->sendResponse($users, "Keresési találatok betöltve");
        }else{
            return $this->sendError("Nincsen jogosultsága ehhez a művelethez");
        }
    }
    
}