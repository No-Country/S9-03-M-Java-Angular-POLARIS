import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { HomeComponent } from './home/home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SharedModule } from '../shared/shared.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { LoginFormComponent } from './login-page/components/login-form/login-form.component';



@NgModule({
  declarations: [
    PublicComponent,
    HomeComponent,
    LandingPageComponent,
    LoginPageComponent,
    LoginFormComponent,
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    SharedModule
  ]
})
export class PublicModule { }
