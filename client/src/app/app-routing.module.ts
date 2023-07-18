import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './public/landing-page/landing-page.component';
import { LoginPageComponent } from './public/login-page/login-page.component';
import { RecoverPasswordComponent } from './public/recover-password/recover-password.component';
import { InstitutionDashboardComponent } from './private/institution/institution-dashboard/institution-dashboard.component';
import { VolunteerRegFormComponent } from './public/login-page/components/volunteer-reg-form/volunteer-reg-form.component';
import { RegisterInstitutionComponent } from './public/register/register-institution/register-institution.component';


const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'register-volunteer', component: VolunteerRegFormComponent},
  { path: 'recover-password', component: RecoverPasswordComponent},
  { path: 'register-institution', component: RegisterInstitutionComponent},
  { path: 'dashboard-institution', component: InstitutionDashboardComponent},
  { path: '**', component: LandingPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
