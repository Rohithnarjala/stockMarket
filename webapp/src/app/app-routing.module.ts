import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {path:'signup',component:SignupComponent},
  {path: 'login/:id', component: LoginComponent },
  {path:'login',component:LoginComponent},
  {path:'editprofile',component:EditProfileComponent,canActivate:[AuthGuard]},
  {path:'editprofile/:user',component:EditProfileComponent,canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
