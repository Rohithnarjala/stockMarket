import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../user';
import { AuthService } from '../auth.service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  user: user;
  profileEditForm: FormGroup;
  editPasswordFlag: boolean;
  passwordFlag: boolean;
  verifyFlag: boolean;

  constructor(private userService: UserService, 
      private authService: AuthService, 
      private authenticateService: AuthenticationService,
      private router: Router) {
    userService.getUser(authService.getUserName()).subscribe(response =>{
      this.user = response;
      console.log(this.user);
    })
   }

  ngOnInit() {
    this.profileEditForm = new FormGroup ({
      oldPassword: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required]),
      confirmPassword: new FormControl('',[Validators.required])
    });
  }

  editPassword(){
    this.editPasswordFlag = true;
  }
  
  passMatch(){
    if(this.profileEditForm.value.password == this.profileEditForm.value.confirmPassword ){
      this.passwordFlag = true;
    }
    else
      this.passwordFlag = false;
  }

  verify(password){
    this.authenticateService.authenticate(this.user.userName, this.profileEditForm.value.oldPassword).subscribe(response =>{
      this.verifyFlag = true;
    })
  }

  submit(){
    this.user.password = this.profileEditForm.value.password;
    this.userService.updateUser(this.user).subscribe(response =>{
        this.router.navigate(['excel-upload']);
    });
  }
}
