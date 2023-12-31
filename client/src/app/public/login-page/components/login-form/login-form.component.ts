import { Component } from '@angular/core';
import { FormBuilder,FormGroup, Validators  } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/shared/models/user/LoginUser';
import { AuthService } from '../../../../shared/services/auth.service';
import jwt_decode from 'jwt-decode';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
  loginForm:FormGroup;
  isLogged:boolean=false;
  loginUser: LoginUser={email:"",password:""};
  emailUsuario: string="";
  password: string="";
  showPassword: boolean = false;

  constructor(private formBuilder:FormBuilder, private router: Router,private authService: AuthService) {
    this.loginForm = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password: ['',[Validators.required, Validators.minLength(8),Validators.maxLength(25),Validators.pattern(/^(?=.*[A-Z])(?=.*[0-9])/)]]
      }
  )}

  ngOnInit(): void {}

  togglePasswordVisibility() {
    this.showPassword = !this.showPassword;
    const passwordInput = document.getElementById('password');
    if (passwordInput) {
      if (this.showPassword) {
        passwordInput.setAttribute('type', 'text');
      } else {
        passwordInput.setAttribute('type', 'password');
      }
    }
  }

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

  login() {
      const credentials = this.loginForm.value;
      console.log("credenciales",credentials)
      this.authService.login(credentials).subscribe(
        (response) => {
          console.log("ccama",response)
          // Aquí obtendrás el token de la respuesta del servidor
          const token = response.jwt;
          
          // Guardar el token en el localStorage
          localStorage.setItem('token', token);

          // Redirigir a la otra página solo si el token existe
          if (token) {
            const decodedToken: any = jwt_decode(token);
            // Verificar el rol del token
            const userRole = decodedToken.rol;
            console.log("ingreso rol",userRole)
            // Redirigir según el rol del usuario
            if (userRole === 'Volunteer') {
              this.router.navigate(['/user']);
            } else if (userRole === 'Institution') {
              console.log("ingreso")
              this.router.navigate(['/dashboard-institution']);
            }
          }
        }
      );
  }

}