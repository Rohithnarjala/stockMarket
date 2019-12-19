import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Company } from '../company/company/company';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = environment.baseUrl;
  constructor(private authenticateService: AuthenticationService, private httpClient: HttpClient) { }

  getAllCompanies(){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<Company[]>(this.baseUrl+'/company-service/stockmarket/get-company', httpOption);
  }

  getStockLatest(code){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/company-service/stockmarket/stock-price/latest/'+code , httpOption);
  }
  
  getStockPrice(code){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/company-service/stockmarket/stock-price/'+code , httpOption);
  }
  getStockDetails(companyCode){
    let token = "Bearer " + this.authenticateService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl+"/company-service/stockmarket/stock-details/"+companyCode,httpOption);
  }
}