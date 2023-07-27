import { Call } from "@angular/compiler";

export class Volunteer{
    id!: Number;
    firstName!: String ;
    lastName!: String ;
    email?: String ;
    password?: String ;
    dni?: String ;
    dateOfBirth?: Date ;
    gender?: String ;
    province!: String ;
    locality!: String ;
    availability!: String ;
    numberCellphone!: String ;
    avatar!: String ;
    description!: String;
    otherSkills?: String;
    imageProfile!: String ;
    skillList?:any[];
    reviewList?:any[];
}

export class ParaDash{
    skillList?:string[]
}



//lo que puse como opcional y no requerido (?) es para las pruebas, para produccion va a ser requerido