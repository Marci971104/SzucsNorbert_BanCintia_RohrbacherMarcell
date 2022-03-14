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
            $table->id("mealid");
            $table->string("mealname");
            $table->integer("calorievalue");
            $table->integer("fat");
            $table->integer("proteine");
            $table->integer("carbonhydrate");
            $table->integer("salt");
            $table->integer("iid")->unsigned();
            $table->foreign("iid")->references("ingerdientsid")->on("ingerdients");
            $table->timestamps();
        });
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
