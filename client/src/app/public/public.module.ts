import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { HomeComponent } from './home/home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { FormVolunteerComponent } from './landing-page/components/form-volunteer/form-volunteer.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatStepperModule } from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

import { SharedModule } from '../shared/shared.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { LoginFormComponent } from './login-page/components/login-form/login-form.component';
import { RecoverPasswordComponent } from './recover-password/recover-password.component';
import { FormInstitutionComponent } from './landing-page/components/form-institution/form-institution.component';
import { InstitutionRegFormComponent } from './login-page/components/institution-reg-form/institution-reg-form.component';



@NgModule({
  declarations: [
    PublicComponent,
    HomeComponent,
    LandingPageComponent,
    FormVolunteerComponent,
    LoginPageComponent,
    LoginFormComponent,
    RecoverPasswordComponent,
    FormInstitutionComponent,
    InstitutionRegFormComponent,
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    SharedModule
  ]
})
export class PublicModule { }
