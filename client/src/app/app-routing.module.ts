import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './public/landing-page/landing-page.component';
import { LoginPageComponent } from './public/login-page/login-page.component';
import { RecoverPasswordComponent } from './public/recover-password/recover-password.component';
import { InstitutionDashboardComponent } from './private/institution/institution-dashboard/institution-dashboard.component';


const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'recover-password', component: RecoverPasswordComponent},
  { path: 'institution', component: InstitutionDashboardComponent},
  { path: '**', component: LandingPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
