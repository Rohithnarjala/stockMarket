import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AuthGuard } from './auth.guard';
import { ExcelUploadComponent } from './excel-upload/excel-upload.component';
import { SummaryComponent } from './summary/summary.component';
import { CompanyComponent } from './company/company/company.component';
import { ChartComponent } from './chart/chart.component';
import { CompanyHomeComponent } from './company-home/company-home.component';
import { ChartCompareComponent } from './chart-compare/chart-compare.component';


const routes: Routes = [
  {path:"",component:CompanyHomeComponent},
  {path:'signup',component:SignupComponent},
  {path: 'login/:id', component: LoginComponent },
  {path:'login',component:LoginComponent},
  {path:'editprofile',component:EditProfileComponent,canActivate:[AuthGuard]},
  {path:'excel-upload', component: ExcelUploadComponent,canActivate:[AuthGuard]},
  {path:'summary',component:SummaryComponent,canActivate:[AuthGuard]},
  {path:'company',component:CompanyComponent,canActivate:[AuthGuard]},
  {path:'chart/:code',component:ChartComponent,canActivate:[AuthGuard]},
  {path:'chart-compare',component:ChartCompareComponent,canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
