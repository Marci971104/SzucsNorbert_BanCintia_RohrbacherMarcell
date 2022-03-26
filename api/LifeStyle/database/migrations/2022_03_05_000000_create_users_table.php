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
            $table->id()->nullOnDelete();
            $table->string('name');
            $table->string('email')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');
            $table->integer('data_id')->unsigned();
            $table->foreign('data_id')->references('id')->on('data');
            $table->rememberToken();
            $table->timestamps();
        });

        DB::table('users')->insert(array(
            'id'=>'1',
            'name'=>'admin',
            'email'=>'admin@email.hu',
            'password'=>bcrypt('admin'),           
            'admin'=>true,
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
        Schema::dropIfExists('users');
    }
};
