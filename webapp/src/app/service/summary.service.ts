import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {
  baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient) { }

  showSummary(){
    return this.httpClient.get<any>(this.baseUrl+"/fileUpload-service/stockmarket/summary")
  }
}