import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-institution',
  templateUrl: './register-institution.component.html',
  styleUrls: ['./register-institution.component.css']
})


export class RegisterInstitutionComponent {

  register: boolean = false


  constructor( private router: Router){}

  ngOnInit():void{}

  inicio(){
    this.router.navigateByUrl('');
  }

  
}
