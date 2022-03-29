import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  host = 'http://localhost:8000/api/';
  constructor(private http: HttpClient, private router: Router) {}

  login(email: string, pass: string) {
    console.log(email);
    console.log(pass);

    let authData = {
      name: email,
      password: pass,
    };
    let data = JSON.stringify(authData);

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    let header = {
      headers: headerObj,
    };

    let endpoint = 'login';
    let url = this.host + endpoint;
    return this.http.post<any>(url, data, header);
  }
  isLoggedIn() {
    if (localStorage.getItem('currentUser') == null) {
      return false;
    }
    let data: any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;
    return token;
  }
  logout() {
    if (localStorage.getItem('currentUser') == null) {
      return;
    }
    let data: any = localStorage.getItem('currentUser');
    localStorage.removeItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token,
    });
    let httpOption = {
      headers: headerObj,
    };
    let endpoint = 'logout';
    let url = this.host + endpoint;

    return this.http.post<any>(url, '', httpOption).subscribe((res) => {
      console.log(res);
      this.router.navigate(['login']);
    });
  }
}