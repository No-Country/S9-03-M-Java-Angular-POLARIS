import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';
import { CountryFormatServiceService } from 'src/app/public/landing-page/services/country-format-service.service';
import { Institution } from 'src/app/shared/models/user/Institution';
import { Volunteer } from 'src/app/shared/models/user/Volunteer';
import { AuthService } from 'src/app/shared/services/auth.service';
import { InstitutionService } from 'src/app/shared/services/institution.service';
import { UserService } from 'src/app/shared/services/user.service';
import { VolunteerFilterService } from 'src/app/shared/services/volunteer-filter.service';




@Component({
  selector: 'app-institution-dashboard',
  templateUrl: './institution-dashboard.component.html',
  styleUrls: ['./institution-dashboard.component.css']
})
export class InstitutionDashboardComponent {
imageUrl: string | null = null;
editState: Boolean = false
instData: any | null = null;
institution: any;
dataToken: any;

public voluntaries: Volunteer[] =[];

constructor(
  private authService: AuthService, 
  private userService: UserService, 
  private institutionService: InstitutionService,
  private volunteerFilterService: VolunteerFilterService,
  ){
   
  }

ngOnInit():void{
this.getInstitutionData();
}

applyFilter(selectedSkill: string) {
  
  console.log('Selected Skill:', selectedSkill); 
  const token = localStorage.getItem('token');
  this.dataToken=token;
  // Llama al servicio para obtener los voluntarios filtrados por la skill seleccionada
  if(token){
    this.volunteerFilterService.filterVolunterSkill(selectedSkill, token).subscribe(
    (response: any) => {
      this.voluntaries = response; // Actualiza la lista de voluntarios con los datos filtrados
    },
    (error: any) => {
      console.error('Error al obtener voluntarios filtrados:', error);
    }
  )};
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
    province: this.institution.province,
    locality: this.institution.locality,
    type: this.institution.type,
    availability: this.institution.availability,
    numberphone: this.institution.numberphone,
    imageProfile: this.institution.imageProfile
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

onFileSelected(event: any): void {
  const file = event.target.files[0];
  if (file) {
    // Crea un objeto URL para mostrar la imagen seleccionada
    this.imageUrl = URL.createObjectURL(file);
  }
}


editar(){
  this.editState = true;
}
cancelEdit(){
  this.editState = false;
}


}


