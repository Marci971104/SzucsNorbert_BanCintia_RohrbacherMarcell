import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  host = 'http://localhost:8000/api/';
  constructor(private http: HttpClient,private router: Router) { }

login(name: string, password: string) {
    
  let authData = {
    email: name,
    password: password
  }
  let data = JSON.stringify(authData);

  let headerObj = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  let header = {
    headers: headerObj
  }

  let endpoint = 'login';
  let url = this.host + endpoint;
  return this.http.post<any>(url, data, header);
}
isLoggedIn(){
  if(localStorage.getItem('currentUser') === null){
    return false;
  }
  let data:any = localStorage.getItem('currentUser');
  let currentUser = JSON.parse(data);
  let token = currentUser.token;
  return token;
}




logout(){
  if(localStorage.getItem('currentUser') === null){
    return;
  }
  let data:any = localStorage.getItem('currentUser');
  localStorage.removeItem('currentUser');
  let currentUser = JSON.parse(data);
  let token = currentUser.token;

  let headerObj = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token
  });
  let httpOption = {
    headers: headerObj
  };
  let endpoint = 'logout';
  let url = this.host + endpoint;

  return this.http.post<any>(url, '', httpOption)
  .subscribe(res => {
    console.log(res);
    this.router.navigate(['']);
  })
}



  register(email: string, name: string, password: string, confirm_password: string, data_id:number) {

    let example={
      name:name,
      email:email,
      password:password,
      confirm_password:confirm_password,
      data_id:data_id
     
    };
    let data = JSON.stringify(example);
    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    let header = {
      headers: headerObj
    }

    let endpoint = 'register';
    let url = this.host + endpoint;
    return this.http.post<any>(url, data, header);
  }
  

}