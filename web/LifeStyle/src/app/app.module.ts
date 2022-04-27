import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MealsComponent } from './meals/meals.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BmiComponent } from './bmi/bmi.component';
import { AboutComponent } from './about/about.component';
import { DrinkComponent } from './drink/drink.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MealsComponent,
    RegisterComponent,
    HomeComponent,
    BmiComponent,
    AboutComponent,
    DrinkComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }