<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('meals', function (Blueprint $table) {
            $table->id()->nullOnDelete();
            $table->string("name");
            $table->double("calorievalue");
            $table->double("fat");
            $table->double("protein");
            $table->double("carbohydrate");
            $table->double("salt");
            $table->timestamps();
        });

      
        DB::table('meals')->insert(array(
            'id'=>'1',
            'name'=>"csirke",
            'calorievalue'=>239,
            'fat'=>3.6,    
            'protein'=>31,  
            'carbohydrate'=>0,
            "salt"=>0.65,
            'created_at'=>'2022-03-20 13:40:17',
            'updated_at'=>'2022-03-20 13:40:17'
        ));

        DB::table('meals')->insert(array(
            'id'=>'2',
            'name'=>"rizs",
            'calorievalue'=>130,
            'fat'=>0.15,    
            'protein'=>1.42,  
            'carbohydrate'=>15,
            "salt"=>0.5,
            'created_at'=>'2022-03-20 13:40:17',
            'updated_at'=>'2022-03-20 13:40:17'
        ));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('meals');
    }
};
