<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class meals extends Model
{
    protected $filltable=[
        "mealid",
        "mealname",
        "calorievalue",
        "fat",
        "protein",
        "carbonhydrate",
        "salt",
        "iid"

    ];
}
