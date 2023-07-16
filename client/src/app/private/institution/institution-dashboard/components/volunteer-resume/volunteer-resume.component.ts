import { Component } from '@angular/core';
import { Volunteer } from 'src/app/shared/models/user/Volunteer';

@Component({
  selector: 'app-volunteer-resume',
  templateUrl: './volunteer-resume.component.html',
  styleUrls: ['./volunteer-resume.component.css']
})
export class VolunteerResumeComponent {

  voluntaries: Volunteer[]=[
    {
      firstName:'Javier',
      lastName: 'Molina',
      province: "Bs. As.",
      locality: "Parque Patricios, CABA",
      occupation: "Terapeuta",
      numberCellphone:"+54 11 2222-4444",
      avatar:"https://reqres.in/img/faces/8-image.jpg"
    },
    {
      firstName:'María',
      lastName: 'Guzman',
      province: "Santafe",
      locality: "Rosario",
      occupation: "Enfermera",
      numberCellphone:"+54 11 2222-4444",
      avatar:"https://reqres.in/img/faces/7-image.jpg"
    },   
    {
      firstName:'Nestor',
      lastName: 'Barrera',
      province: "Entre Rios",
      locality: "Nogoyá",
      occupation: "Estudiante",
      numberCellphone:"+54 11 2222-4444",
      avatar:"https://reqres.in/img/faces/9-image.jpg"
    }
  ]

}
