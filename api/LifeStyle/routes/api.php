<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\API\AuthController;
use App\Http\Controllers\API\MealController;
use App\Http\Controllers\API\DataController;
use App\Http\Controllers\API\UserController;
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::post("/register",[AuthController::class,"signup"]);
Route::post("/login",[AuthController::class,"signin"]);
Route::post("/logout",[AuthController::class,"logout"]);
//Route::post("/delete",[MealController::class,"destroy"]);




Route::group( ["middleware" => ["auth:sanctum"]], function(){
    Route::post("/store-meal",[MealController::class,"store"]);
    Route::get("/show-meal/{id}",[MealController::class,"show"]);
    Route::get( "/search-meal/{name}", [MealController::class, "search" ]);
    Route::get("/show-all-meal",[MealController::class,"showAll"]);
    Route::put("/update-meal/{id}",[MealController::class,"update"]);
    Route::delete("/delete-meal/{id}",[MealController::class,"destroy"]);


    Route::post("/store-data",[DataController::class,"storeData"]);
    Route::get("/show-data/{dataid}",[DataController::class,"show"]);
    Route::get("/show-all-data",[DataController::class,"showAllData"]);
    //Route::get( "/search-data/{dataid}", [DataController::class, "search" ]);
    Route::put("/update-data/{id}",[DataController::class,"update"]);
    Route::delete("/delete-data/{dataid}",[DataController::class,"destroy"]);

    //Route::post("/store-user",[UserController::class,"storeUser"]);
    Route::get("/show-user/{id}",[UserController::class,"show"]);
    Route::get("/show-all-user",[UserController::class,"showAll"]);
    Route::get( "/search-user/{id}", [UserController::class, "search" ]);
    Route::put("/update-user/{id}",[UserController::class,"update"]);
    Route::delete("/delete-user/{id}",[UserController::class,"destroy"]);
});
