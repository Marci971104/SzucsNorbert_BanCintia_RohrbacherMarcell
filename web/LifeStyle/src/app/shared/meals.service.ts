import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { identifierName } from '@angular/compiler';

@Injectable({
  providedIn: 'root',
})
export class MealsService {
  host = 'http://localhost:8000/api/';
  constructor(private http: HttpClient) {}
  getMeals() {

    let endpoint = 'show-all-meal';
    let url = this.host + endpoint;
    return this.http.get<any>(url);
    
  }
  addMeal(name:string, calorievalue:string, fat:string, protein:string, carbohydrate:string, salt:string){

    let newData = {
     
      name: name,
      calorievalue: calorievalue,
      fat: fat,
      protein: protein,
      carbohydrate: carbohydrate,
      salt: salt
    };

    let data = JSON.stringify(newData);
    let data2: any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(data2);
   // let token = currentUser.token;

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Bearer ' ,
    });
    let header = {
      headers: headerObj,
    };
    let endpoint = 'store-meal';
    let url = this.host + endpoint;
    return this.http.post<any>(url, data, header);
  }

}
