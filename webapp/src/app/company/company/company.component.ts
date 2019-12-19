import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/service/company.service';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { Company } from './company';
import { Router } from '@angular/router';


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companyList: any;
  filteredCompany: any;
  user: String;
  company: any;
  stockDetailsLatestList: any;

  constructor(private companyService :CompanyService,private authenticationService:AuthenticationService,private router:Router) { }

  ngOnInit() {
    this.companyService.getAllCompanies().subscribe(company =>{
      console.log("get company component");
      this.companyList = company;
      this.filteredCompany = this.companyList;
      this.user = this.authenticationService.getUser();
    });
  }
  filterList($event) {


    this.filteredCompany = this.companyList.filter(
      (item: Company) => item.name.toLocaleLowerCase().indexOf($event) != -1
    );
  }
  getCompanyDetails(id){
    this.companyList.forEach(comp =>{
      if(comp.id == id){
        this.company = comp;
      }
    });
    this.companyService.getStockLatest(this.company.companyCode).subscribe(response =>{
      this.stockDetailsLatestList = response;
    })
  }

  plot(companyCode){
    this.router.navigate(['/chart',companyCode]);
  }
 
 
}


