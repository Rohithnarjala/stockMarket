import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { user } from 'src/app/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: any;
  newUserFlag: boolean =false;
  user: any = {
    userName:"",
    password:"",
    email:"",
    contactNumber:"",
    confirmed:null
  };
  constructor(private userService: UserService,private router: Router) { }

  ngOnInit() {
    this.signupForm = new FormGroup({
      'userName': new FormControl(null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(20)
      ]),
      'password': new FormControl(null, [
        Validators.required
      ]),
      'email': new FormControl(null, [
        Validators.required
      ]),
      'contactNumber': new FormControl(null, [
        Validators.required,
         Validators.minLength(10),
        Validators.maxLength(10)
      ]),
    });
  }

confirmed:boolean =false;
signup(){
this.user ={
  userName:this.signupForm.value.userName,
  password:this.signupForm.value.password,
  email:this.signupForm.value.email,
  contactNumber:this.signupForm.value.contactNumber,
  confirmed:this.confirmed
}
console.log( this.user);
   
this.userService.addUser(this.user).subscribe((response)=>{
  this.newUserFlag = true;
  console.log( this.newUserFlag);
  // if(response==true){
  //   //this.router.navigate(['login']);
  // } 
  this.router.navigate(["/login"]);
},(error)=>{
  this.newUserFlag = false;
});
}
}

