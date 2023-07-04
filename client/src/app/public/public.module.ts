import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { HomeComponent } from './home/home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';


@NgModule({
  declarations: [
    PublicComponent,
    HomeComponent,
    LandingPageComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
  ]
})
export class PublicModule { }
