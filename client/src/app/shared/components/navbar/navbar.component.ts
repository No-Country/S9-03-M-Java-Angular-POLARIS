import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  showNavbar: boolean = true;
  username: string | null = null; // Variable para almacenar el nombre de usuario

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit():void{
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Verifica la URL actual y oculta el navbar en la página de inicio de sesión (login)
        this.showNavbar = this.router.url !== '/login';
        // Si el usuario ha iniciado sesión, obtén su nombre de usuario desde el token
        if (this.showNavbar && this.authService.isLoggedIn()) {
            this.username = this.authService.getUsernameFromToken();
            console.log("username",this.username)
        }
      }
    });
  }

  login(){
    this.router.navigateByUrl("/login");
  }
  inicio(){
    this.router.navigateByUrl('');
  }
  
}
