import { AuthGuard } from './shared/auth.guard';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MealsComponent } from './meals/meals.component';

const routes: Routes = [
  { path: '', component: LoginComponent },

  {path:'login',component:LoginComponent},
  {path:'meals',component:MealsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}