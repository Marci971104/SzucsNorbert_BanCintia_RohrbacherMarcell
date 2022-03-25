<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class data extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array|\Illuminate\Contracts\Support\Arrayable|\JsonSerializable
     */
    public function toArray($request)
    {
        return [
            "id"=>$this->id,
            "height"=>$this->height,
            "weight"=>$this->weight,
            "age"=>$this->age,
            "gender"=>$this->gender, 
            "allcalories"=>$this->allcalories,
            "waterintake"=>$this->waterintake
        ];
    }
}
