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
        Schema::create('users', function (Blueprint $table) {
            $table->id("id")->nullOnDelete();
            $table->string('name');
            $table->string('email')->unique();
            $table->string('password');
            $table->integer('data_id')->unsigned()->nullOnDelete();
            $table->foreign('data_id')->references('id')->on('data');
            $table->boolean('admin')->default(false);
            $table->rememberToken();
            $table->timestamps();
        });

        DB::table('users')->insert(array(
            'id'=>'1',
            'name'=>'admin',
            'email'=>'admin@email.hu',
            'password'=>bcrypt('admin'),    
            'data_id'=>1,  
            'admin'=>true,
            'created_at'=>'2022-03-20 13:40:17',
            'updated_at'=>'2022-03-20 13:40:17'
        ));


        DB::table('users')->insert(array(
            'id'=>'2',
            'name'=>'TesztUser',
            'email'=>'teszt@teszt.hu',
            'password'=>bcrypt('teszt'),
            'data_id'=>2,
            'admin'=>false,
            'created_at'=>'2022-02-20 18:00:00',
            'updated_at'=>'2022-02-20 18:00:00'
        ));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('users');
    }
};
