import { Component, OnInit } from '@angular/core';
import { Summary } from './summary';
import { SummaryService } from '../service/summary.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
  summary:any;
  summary1:Summary;
  constructor(private importExcel:SummaryService) { }

  ngOnInit() {
  this.summary={
    noOfRecords:0,
    companyName:"",
    maxDate:new Date(),
    minDate: new Date()
  }
  
this.importExcel.showSummary().subscribe((response:any)=>{this.summary=response})
  
  }
}