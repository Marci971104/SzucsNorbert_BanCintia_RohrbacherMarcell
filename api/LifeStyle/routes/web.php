<?php

use App\Http\Controllers\Auth\AuthenticatedSessionController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MealController;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });


Route::middleware("auth")->group(function(){
    Route::get("/new-meal", [MealController::class, "create"]);
    Route::get("/edit-meal/{id}",[MealController::class, "edit"]);
    Route::get("/delete-meal/{id}",[MealController::class, "destroy"]);
});

Route::get("/",[MealController::class, "index"] );
Route::post("/store-meal",[MealController::class, "store"]);
Route::put("/update-meal",[MealController::class, "update"]);
Route::get("/logout",[AuthenticatedSessionController::class, "destroy"]);



Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth'])->name('dashboard');

require __DIR__.'/auth.php';
