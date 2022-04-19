import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bmi',
  templateUrl: './bmi.component.html',
  styleUrls: ['./bmi.component.css']
})
export class BmiComponent implements OnInit {
  title = 'Testtömegindex';
  weight:string;
  height:string;
  index:string;

  constructor(){
    this.weight = ''
    this.height = '';
    this.index = '';

  }
  ngOnInit(): void {
    
  }
  calcIndex():any{
    let index = Number(this.weight)/Math.pow(Number(this.height)/100,2);
   
    index=Number(index.toFixed(2));
    this.index = String(index);
    this.weight = '';
    this.height = '';

    
  }
}

