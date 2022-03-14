<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class meals extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array|\Illuminate\Contracts\Support\Arrayable|\JsonSerializable
     */
    public function toArray($request)
    {
        return[
            "mealid"=>this->mealid,
            "mealname"=>this->mealname,
            "calorievalue"=>this->calorievalue,
            "fat"=>this->fat,
            "protein"=>this->protein,
            "carbonhydrate"=>this->carbonhydrate,
            "salt"=>this->salt,
            "iid"=>this->iid
        ];
    }
}
