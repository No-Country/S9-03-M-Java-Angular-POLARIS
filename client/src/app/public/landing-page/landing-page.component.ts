import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {
  public backgroundImages: string[] = [
    'https://images.pexels.com/photos/7488247/pexels-photo-7488247.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/7188965/pexels-photo-7188965.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/7188960/pexels-photo-7188960.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/7188923/pexels-photo-7188923.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
  ];

  public randomBackgroundImage!: string;

  constructor(private router: Router){
  }
  ngOnInit(){
    const randomIndex = Math.floor(Math.random() * this.backgroundImages.length);
    this.randomBackgroundImage = `${this.backgroundImages[randomIndex]}`;

    console.log(this.randomBackgroundImage);
    
  }

  navigateTo(route: string) {
    this.router.navigateByUrl(route)
  }
}
