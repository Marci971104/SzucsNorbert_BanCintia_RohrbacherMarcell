import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators  } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm!:FormGroup;
  clicked = false;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('[a-zéáíűőúöüóA-ZÉÁÍSŰŐÚÖÜÓ0-9]+'), Validators.minLength(4), Validators.maxLength(50)]),
      email: new FormControl('', [Validators.required, Validators.email,  Validators.maxLength(255)]),
      password: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
      confirm_password: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]),
     
    });
  }
  register(){
    let name = this.registerForm.value.name;
    let email = this.registerForm.value.email;
    let password = this.registerForm.value.password;
    let confirm_password = this.registerForm.value.confirm_password;
    

    if(password != confirm_password){
      alert("A jelszavak nem egyeznek meg!")
      this.registerForm.reset();
    }else{
      this.auth.register(name, email, password,confirm_password)
      .subscribe(
        (res) => {
          alert("Sikeres regisztráció!");
          this.router.navigate(['/login']);
        }, (error) => {
          console.error(error);
          alert("A regisztráció sikertelen!");
          this.registerForm.reset();
        })
    }
  }
}