<?php
namespace App\Http\Controllers\API;
use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use Illuminate\Support\Facades\Auth;
use Validator;
use App\Models\User;

class AuthController extends BaseController
{

    public function signup(Request $request)
    {
        $validator = Validator::make($request->all(),
        [
            "name"=>"required",
            "email"=>"required",
            "password"=>"required",
            "confirm_password"=>"required|same:password",
            'data_id'=>'required'
        ]);
        if($validator->fails())
        {
            return $this->sendError("Error", $validator->errors());
        }
        $input = $request->all();
        $input["password"] = bcrypt($input["password"]);
        $user = User::create($input);
        $success["token"] = $user->createToken("MyAuthApp")->plainTextToken;
        $success["name"]= $user->name;
        return $this->sendResponse($success, "User created successfully");
    }

    public function signin(Request $request){
        if(Auth::attempt(["email"=>$request->email,"password" =>$request->password])){
            $authUser = Auth::user();
            $success["token"]= $authUser->createToken("myapitoken")->plainTextToken;
            $success["name"] = $authUser->name;

            return $this->sendResponse($success,"Sikeres bejelentkezés");
        }else{
            return $this->sendError("Unauthorised",["error"=>"Hibás adatok"]);
        }
    }
    
    public function logout(Request $request)
    {
        auth("sanctum")->user()->currentAccessToken()->delete();
        return response()->json('Signed out');
    }
}