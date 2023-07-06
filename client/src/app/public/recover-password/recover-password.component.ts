import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/shared/models/user/LoginUser';

@Component({
  selector: 'app-recover-password',
  templateUrl: './recover-password.component.html',
  styleUrls: ['./recover-password.component.css']
})
export class RecoverPasswordComponent {
  loginForm:FormGroup;
  isLogged:boolean=false;
  loginUser: LoginUser={email:"",password:""};
  emailUsuario: string="";
  password: string="";

  constructor(private formBuilder:FormBuilder, private router: Router) {
    this.loginForm = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password: ['',[Validators.required, Validators.minLength(8),Validators.maxLength(25),Validators.pattern(/^(?=.*[A-Z])(?=.*[0-9])/)]]
      }
  )}

  ngOnInit(): void {}

  // OnLogin
  onLogin(event: any) {
   console.log("usuario logeado")
  }

  // Properties Validators
  get Email() {
    return this.loginForm.get('email')
  }
  get Password() {
    return this.loginForm.get('password')
  }

}
