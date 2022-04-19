import { AuthGuard } from './shared/auth.guard';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MealsComponent } from './meals/meals.component';
import { RegisterComponent } from './register';
import { HomeComponent } from './home/home.component';
import { BmiComponent } from './bmi/bmi.component';
import { AboutComponent } from './about/about.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {path:'home',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'bmi',component:BmiComponent},

  {path:'login',component:LoginComponent},
  {path:'meals',component:MealsComponent},
  {path:'register', component: RegisterComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
