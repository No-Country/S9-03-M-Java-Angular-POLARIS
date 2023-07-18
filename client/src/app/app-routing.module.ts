import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './public/landing-page/landing-page.component';
import { LoginPageComponent } from './public/login-page/login-page.component';
import { RecoverPasswordComponent } from './public/recover-password/recover-password.component';
import { VolunteerRegFormComponent } from './public/login-page/components/volunteer-reg-form/volunteer-reg-form.component';


const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'register-volunteer', component: VolunteerRegFormComponent},
  { path: 'recover-password', component: RecoverPasswordComponent},
  { path: 'user', loadChildren:() => import('./private/private.module').then(m => m.PrivateModule)},
  { path: '**', component: LandingPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
