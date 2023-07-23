import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  showNavbar: boolean = true;
  username: string | null = null; // Variable para almacenar el nombre de usuario
  user:any;
  constructor(private router: Router, private authService: AuthService,private userService: UserService) { }

  ngOnInit():void{
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Verifica la URL actual y oculta el navbar en la página de inicio de sesión (login)
        this.showNavbar = this.router.url !== '/login';
        // Si el usuario ha iniciado sesión, obtén su nombre de usuario desde el token
        if (this.showNavbar && this.authService.isLoggedIn()) {
            this.username = this.authService.getUsernameFromToken();
            const token = localStorage.getItem('token');
            if(this.username && token){
              this.userService.getUserById(this.username, token).subscribe({
                next: (userData) => {
                  this.user = userData;
                },
                error: (error) => {
                  console.error('Error al obtener el usuario:', error);
                }
              });
            }
            // console.log("username",this.username)
        }
      }
    });
  }
  logout(){
    this.authService.onLogout();
  }
  login(){
    this.router.navigateByUrl("/login");
  }
  inicio(){
    this.router.navigateByUrl('');
  }
  
}
