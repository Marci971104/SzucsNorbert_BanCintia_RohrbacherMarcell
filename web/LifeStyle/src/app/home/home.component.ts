import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { MealsService } from './../shared/meals.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  
  
  constructor(

    private auth: AuthService

  ) {


   }
 
  
 
  ngOnInit(): void {

    
  }
 
    logout(){
      this.auth.logout();
    }
    }
  


