<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\API\AuthController;
use App\Http\Controllers\API\LifestyleController;
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
Route::post("/login",[AuthController::class,"login"]);
Route::post("/logout",[AuthController::class,"logout"]);
Route::post("/delete",[LifestyleController::class,"destroy"]);



Route::group( ["middleware" => ["auth:sanctum"]], function(){
    Route::post("/products",[ProductsController::class,"store"]);
    Route::put("/products/{products}",[ProductsController::class,"update"]);
    Route::delete("/products/{id}",[ProductsController::class,"destroy"]);
});
