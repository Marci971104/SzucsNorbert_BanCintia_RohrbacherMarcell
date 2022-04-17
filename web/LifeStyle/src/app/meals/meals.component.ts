import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MealsService } from './../shared/meals.service';
import { AuthService } from './../shared/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-groups',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {
  registerForm !: FormGroup;
  meal : any;
  toDisplay = false;


  constructor(

    private auth: AuthService,
    private meals: MealsService,
    private formBuilder: FormBuilder

    ) {}

  ngOnInit(): void {
    
    this.getMeals();

      this.registerForm = new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern('[a-zéáíűőúöüóA-ZÉÁÍSŰŐÚÖÜÓ0-9]+'), Validators.minLength(4), Validators.maxLength(50)]),
        calorievalue: new FormControl('', [Validators.required, Validators.email,  Validators.maxLength(255)]),
        fat: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]),
        protein: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]),
        carbohydrate: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]),
        salt: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]),



    });
  }
  addMeal() {
    
    let name = this.registerForm.value.name;
    let calorievalue = this.registerForm.value.calorievalue;
    let fat = this.registerForm.value.fat;
    let protein = this.registerForm.value.protein;
    let carbohydrate = this.registerForm.value.carbohydrate;
    let salt = this.registerForm.value.salt;

    this.meals.addMeal(name, calorievalue, fat, protein, carbohydrate, salt).subscribe((res) => {
      console.log(res);

      this.getMeals();
  });
  }

  logout(){
    this.auth.logout();
  }


  getMeals(){
    this.meals.getMeals()
    .subscribe(res => {
    console.log(res);
    this.meal = res;
    })
  }

  toggleData() {
    this.toDisplay = !this.toDisplay;
  }

}
