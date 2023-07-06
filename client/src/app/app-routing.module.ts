import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './public/landing-page/landing-page.component';
import { LoginPageComponent } from './public/login-page/login-page.component';
import { FormVolunteerComponent } from './public/landing-page/components/form-volunteer/form-volunteer.component';


const routes: Routes = [
  { path: '', component: FormVolunteerComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'user', loadChildren:() => import('./private/private.module').then(m => m.PrivateModule)},
  { path: '**', component: FormVolunteerComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
