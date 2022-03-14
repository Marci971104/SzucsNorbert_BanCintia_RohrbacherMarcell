<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class ingerdients extends JsonResource
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
            "ingredientsid"=>this->ingerdientsid,
            "name"=>this->name
        ];
    }
}
