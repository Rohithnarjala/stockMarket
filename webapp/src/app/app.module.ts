import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { FooterComponent } from './site/footer/footer.component';
import { HeaderComponent } from './site/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ExcelUploadComponent } from './excel-upload/excel-upload.component';
import { SummaryComponent } from './summary/summary.component';
import { CompanySearchComponent } from './company/company-search/company-search.component';
import { CompanyComponent } from './company/company/company.component';
import { ChartComponent } from './chart/chart.component';
import { CompanyHomeComponent } from './company-home/company-home.component';
import { ChartCompareComponent } from './chart-compare/chart-compare.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    FooterComponent,
    HeaderComponent,
    EditProfileComponent,
    ExcelUploadComponent,
    SummaryComponent,
    CompanySearchComponent,
    CompanyComponent,
    ChartComponent,
    CompanyHomeComponent,
    ChartCompareComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
