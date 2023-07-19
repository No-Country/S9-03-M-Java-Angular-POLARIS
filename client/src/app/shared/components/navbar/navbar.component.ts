import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  showNavbar: boolean = true;
  constructor( private router: Router,){}

  ngOnInit():void{
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Verifica la URL actual y oculta el navbar en la página de inicio de sesión (login)
        this.showNavbar = this.router.url !== '/login';
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
