import { Component, OnInit } from '@angular/core';
import { MealsService } from '../shared/meals.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-drink',
  templateUrl: './drink.component.html',
  styleUrls: ['./drink.component.css']
})
export class DrinkComponent implements OnInit {
  netImage:any = "drink/image/pet-bottle_kara_4657-500x375.png";

 water: any;
  count= 0
  counter(type:string)
  
  {
    type=='add'?this.count++:this.count--;
  }
  
  constructor(
    private waters: MealsService
    ) {
      
      
      
      
    }
    
    ngOnInit(): void {
      
      
      
    }
    

    reset(){
      this.count=0
    }

  }


