import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrivateRoutingModule } from './private-routing.module';
import { PrivateComponent } from './private.component';
import { InstitutionDashboardComponent } from './institution/institution-dashboard/institution-dashboard.component';
import { VolunteerResumeComponent } from './institution/institution-dashboard/components/volunteer-resume/volunteer-resume.component';


@NgModule({
  declarations: [
    PrivateComponent,
    InstitutionDashboardComponent,
    VolunteerResumeComponent
  ],
  imports: [
    CommonModule,
    PrivateRoutingModule
  ]
})
export class PrivateModule { }
