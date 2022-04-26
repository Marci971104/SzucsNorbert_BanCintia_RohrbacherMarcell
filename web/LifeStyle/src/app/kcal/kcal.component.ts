import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-kcal',
  templateUrl: './kcal.component.html',
  styleUrls: ['./kcal.component.css']
})
export class KcalComponent implements OnInit {
  title = 'Ajánlott napi kalóriabevitel';
  age:string;
  gender:
  weight:string;
  height:string;
  index:string;

  constructor(){
    this.age='';
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

