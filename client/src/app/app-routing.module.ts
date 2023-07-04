import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './public/landing-page/landing-page.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'guest', loadChildren:() => import('./public/public.module').then(m => m.PublicModule) },
  { path: 'user', loadChildren:() => import('./private/private.module').then(m => m.PrivateModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
