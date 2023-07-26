import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';
import { CountryFormatServiceService } from 'src/app/public/landing-page/services/country-format-service.service';
import { Institution } from 'src/app/shared/models/user/Institution';
import { AuthService } from 'src/app/shared/services/auth.service';
import { InstitutionService } from 'src/app/shared/services/institution.service';
import { UserService } from 'src/app/shared/services/user.service';




@Component({
  selector: 'app-institution-dashboard',
  templateUrl: './institution-dashboard.component.html',
  styleUrls: ['./institution-dashboard.component.css']
})
export class InstitutionDashboardComponent {

editState: Boolean = false
instData: any | null = null;
institution: any;
dataToken: any;

constructor(private authService: AuthService, private userService: UserService, private institutionService: InstitutionService){}

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
          console.log("al fondo hay sitio",this.institution)
        },
        error: (error) => {
          console.error('Error al obtener el usuario:', error);
        }
      });
    }
  }
}


editInstitution(){
  const datosActualizados: Institution = {
    id: this.institution.id,
    name: this.institution.name,
    cuit: this.institution.cuit,//
    email: this.institution.email,
    password: this.institution.password,//
    province: this.institution.province,
    locality: this.institution.locality,
    type: this.institution.type,
    availability: this.institution.availability,
    numberphone: this.institution.numberphone,
    imageProfile: this.institution.imageProfile,
    rol: this.institution.rol//
  };
  const token = localStorage.getItem('token');
  this.dataToken=token;
  if(token){
  this.institutionService.updateInstitucion(datosActualizados,token)
    .subscribe(
      response => {
        // Manejo de la respuesta del servidor, si es necesario.
        console.log('Institución actualizada:', response);
      },
      error => {
        // Manejo de errores, si es necesario.
        console.error('Error al actualizar la institución:', error);
      }
    );
}
this.editState = false;
}



editar(){
  this.editState = true;
}



}


