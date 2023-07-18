import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
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
import { MatCheckboxModule } from '@angular/material/checkbox';

import { SharedModule } from '../shared/shared.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { LoginFormComponent } from './login-page/components/login-form/login-form.component';
import { RecoverPasswordComponent } from './recover-password/recover-password.component';
import { FormInstitutionComponent } from './register/register-institution/components/form-institution/form-institution.component';
import { VolunteerRegFormComponent } from './login-page/components/volunteer-reg-form/volunteer-reg-form.component';
import { RegisterInstitutionComponent } from './register/register-institution/register-institution.component';



@NgModule({
  declarations: [
    PublicComponent,
    LandingPageComponent,
    FormVolunteerComponent,
    LoginPageComponent,
    LoginFormComponent,
    RecoverPasswordComponent,
    FormInstitutionComponent,
    VolunteerRegFormComponent,
    RegisterInstitutionComponent,
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
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    SharedModule
  ]
})
export class PublicModule { }
