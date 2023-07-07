import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { NavbarComponent } from './components/navbar/navbar.component';
@NgModule({
  declarations: [
    NavbarComponent,
  ],
  imports: [
    CommonModule
  ],
  exports:[
    NavbarComponent,
    ReactiveFormsModule
  ]
})
export class SharedModule { }
