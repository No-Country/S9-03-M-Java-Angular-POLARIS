import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';
import { CountryFormatServiceService } from 'src/app/public/landing-page/services/country-format-service.service';
import { AuthService } from 'src/app/shared/services/auth.service';
import { UserService } from 'src/app/shared/services/user.service';



@Component({
  selector: 'app-institution-dashboard',
  templateUrl: './institution-dashboard.component.html',
  styleUrls: ['./institution-dashboard.component.css']
})
export class InstitutionDashboardComponent {
instData: any | null = null;
institution: any;
dataToken: any;

constructor(private authService: AuthService, private userService: UserService){}

ngOnInit():void{
this.getInstitutionData();
}


getInstitutionData(){
  const instDataRaw= this.authService.getUsernameFromToken() ;
  this.instData=instDataRaw;
  const {Id,rol} = this.instData;
  console.log("paisana jacinta",rol)
  const token = localStorage.getItem('token');
  this.dataToken=token;
  if(this.instData && token){
  if(rol==="Institution"){
      console.log("al fondo hay sitio")
      this.userService.getInstitutionById(Id, token).subscribe({
        next: (instData) => {
          this.institution = instData;
          console.log("al fondo hay sitio",this.institution.name)
        },
        error: (error) => {
          console.error('Error al obtener el usuario:', error);
        }
      });
    }
  }
}



}


