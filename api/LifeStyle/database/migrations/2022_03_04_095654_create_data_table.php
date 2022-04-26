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
            $table->string("gender");
            $table->integer("allcalories");
            $table->integer("waterintake");

            $table->timestamps();
        });


        DB::table('data')->insert(array(
            'id'=>'1',
            'height'=>180,
            'weight'=>75,
            'age'=>24,    
            'gender'=>"férfi",  
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
            'gender'=>"nő",  
            'allcalories'=>0,
            "waterintake"=>0,
            'created_at'=>'2022-03-20 13:40:17',
            'updated_at'=>'2022-03-20 13:40:17'
        ));

        DB::table('data')->insert(array(
            'id'=>'3',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'4',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'5',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'6',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'7',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'8',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'9',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
        ));

        DB::table('data')->insert(array(
            'id'=>'10',
            'height'=>0,
            'weight'=>0,
            'age'=>0,    
            'gender'=>"",  
            'allcalories'=>0,
            "waterintake"=>0,
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
