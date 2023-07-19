import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor( private router: Router,){}

  ngOnInit():void{}

  login(){
    this.router.navigateByUrl("/login");
  }
  inicio(){
    this.router.navigateByUrl('');
  }
  
}
