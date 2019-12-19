import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';

import * as FileSaver from 'file-saver';
const EXCEL_EXTENSION = '.csv';
import HC_exportData from 'highcharts/modules/export-data';
import { Company } from '../company/company/company';
import { CompanyService } from '../service/company.service';
HC_exportData(Highcharts)

@Component({
  selector: 'app-chart-compare',
  templateUrl: './chart-compare.component.html',
  styleUrls: ['./chart-compare.component.css']
})
export class ChartCompareComponent implements OnInit {
  companies: Company[] = [];
  companyOne:string;
  companyTwo:string;
  dataLoaded: Promise<boolean>;
  stockData: any[];
  chart:Highcharts.Chart;
  diffrentFlag:boolean;
  
  emptyFlag: boolean;
  public options: any = {
    chart: {
      type: 'line',

    },
    title: {
      text: 'Select Company code First'
    },
    credits: {
      enabled: false
    },
    tooltip: {
      formatter: function () {
        return 'x: ' + Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +
          ' y: ' + this.y.toFixed(2);
      }
    },
    xAxis: {
      type: 'datetime',
      labels: {
        formatter: function () {
          return Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.value);
        }
      }
    },

    

  responsive: {
      rules: [{
          condition: {
              maxWidth: 500
          },
          chartOptions: {
              legend: {
                  layout: 'horizontal',
                  align: 'center',
                  verticalAlign: 'bottom'
              }
          }
      }]
  }
}
  constructor(private companyService:CompanyService) { }

  ngOnInit() {
    this.companyOne="";
    this.companyTwo="";
    this.diffrentFlag = false;
    this.companyService.getAllCompanies().subscribe((response: Company[]) => {
      this.companies = response;
      this.dataLoaded = Promise.resolve(true);
      this.chart=Highcharts.chart('showdata', this.options);
    })
  }
  saveCompanyTwo(companyCode){
    this.companyTwo = companyCode;
  }
  
  saveCompanyOne(companyCode){
    this.companyOne = companyCode;
  }
  filterSelectedData(companyCode: string) {
    if(this.companyOne =="" || this.companyTwo==""){
      this.emptyFlag=true;
    }else{
      this.emptyFlag=false;
    }
    if(this.companyTwo != companyCode && !this.emptyFlag){
     
      this.diffrentFlag =false;
    this.options.title.text = "Stock-Details of "+this.companyOne+" and "+this.companyTwo;
    this.companyService.getStockPrice(companyCode).subscribe((response: any) => {
      this.stockData = response;
      let data: any[] = [];
      this.stockData.forEach((item) => {
        let point: any[] = [];
        point.push(Date.parse(item.date.split("T", 1) + "T" + item.time));
        point.push(item.currentPrice);
        data.push(point);
        data.sort((n1, n2) => {
          if (n1[0] > n2[0]) {
            return 1;
          } else {
            return -1;
          }
        });
        this.chart.destroy();
        this.chart=Highcharts.chart('showdata',this.options);        
        this.chart.addSeries({
          name: companyCode,
          data:data,
          type:"line"
        },true,true);
        this.chart.redraw()
      });
      
  this.compareSecond(this.companyTwo);

    });
    
  }else{
    if(this.companyOne == this.companyTwo && this.companyOne!="")
    this.diffrentFlag=true;
  }
}

compareSecond(companyCode){
  if(companyCode!=this.companyOne){
    this.diffrentFlag =false;
    this.companyService.getStockPrice(companyCode).subscribe((response: any) => {
      this.stockData = response;
      let data: any[] = [];
      this.stockData.forEach((item) => {
        let point: any[] = [];
        point.push(Date.parse(item.date.split("T", 1) + "T" + item.time));
        point.push(item.currentPrice);
        data.push(point);
        data.sort((n1, n2) => {
          if (n1[0] > n2[0]) {
            return 1;
          } else {
            return -1;
          }
        });        
        
      });
      this.chart.addSeries({
        name: companyCode,
        data:data,
        type:"line"
      },true,true);
      this.chart.redraw()
    });
  }else{
    this.diffrentFlag =true;
  }
}

compareBoth(){
  this.filterSelectedData(this.companyOne);
}


}
