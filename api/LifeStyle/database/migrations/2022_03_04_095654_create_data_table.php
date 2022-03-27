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
        Schema::create('data', function (Blueprint $table) {
            $table->increments("id")->nullOnDelete();
            $table->integer("height");
            $table->integer("weight");
            $table->integer("age");
            $table->boolean("gender");
            $table->integer("allcalories");
            $table->integer("waterintake");

            $table->timestamps();
        });


        DB::table('data')->insert(array(
            'id'=>'1',
            'height'=>180,
            'weight'=>75,
            'age'=>24,    
            'gender'=>1,  
            'allcalories'=>0,
            "waterintake"=>0,
            'created_at'=>'2022-03-20 13:40:17',
            'updated_at'=>'2022-03-20 13:40:17'
        ));

        
        DB::table('data')->insert(array(
            'id'=>'2',
            'height'=>170,
            'weight'=>65,
            'age'=>19,    
            'gender'=>2,  
            'allcalories'=>0,
            "waterintake"=>0,
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
        Schema::dropIfExists('data');
    }
};
