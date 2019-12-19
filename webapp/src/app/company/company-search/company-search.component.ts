import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-company-search',
  templateUrl: './company-search.component.html',
  styleUrls: ['./company-search.component.css']
})
export class CompanySearchComponent implements OnInit {
  @Output() changeCompanyList: any;

  searchString: String;

  constructor(private authenticateService: AuthenticationService) {
    this.changeCompanyList = new EventEmitter();
    
   }

  ngOnInit() {
   
  }
  filterCompany() {
    this.changeCompanyList.emit(this.searchString);
  }
 
  
}