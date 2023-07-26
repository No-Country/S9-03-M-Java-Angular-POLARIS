import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { PrivateRoutingModule } from './private-routing.module';
import { PrivateComponent } from './private.component';
import { InstitutionDashboardComponent } from './institution/institution-dashboard/institution-dashboard.component';
import { VolunteerResumeComponent } from './institution/institution-dashboard/components/volunteer-resume/volunteer-resume.component';
import { VolunteerDashboardComponent } from './volunteer/volunteer-dashboard/volunteer-dashboard.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    PrivateComponent,
    InstitutionDashboardComponent,
    VolunteerResumeComponent,
    VolunteerDashboardComponent
  ],
  imports: [
    CommonModule,
    PrivateRoutingModule,
    SharedModule,
    FormsModule
  ]
})
export class PrivateModule { }
