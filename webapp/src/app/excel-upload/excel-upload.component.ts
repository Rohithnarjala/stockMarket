import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-excel-upload',
  templateUrl: './excel-upload.component.html',
  styleUrls: ['./excel-upload.component.css']
})
export class ExcelUploadComponent implements OnInit {
  baseUrl = environment.baseUrl;
  uploadFlag:boolean=false;
  apiEndPoint = this.baseUrl+"/fileUpload-service/stockmarket/upload";
 

  constructor(private http:HttpClient) {
  }

  ngOnInit(){}

  fileChange(event) {
    let fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      let file: File = fileList[0];
      let formData: FormData = new FormData();
      formData.append('uploadFile', file, file.name);
      let headers = new Headers();
      headers.append('Accept', 'application/json');
      this.http.post<any>(this.apiEndPoint, formData)
        .subscribe(
              (response)=>this.uploadFlag =true
        
        )
    }
  }
}
