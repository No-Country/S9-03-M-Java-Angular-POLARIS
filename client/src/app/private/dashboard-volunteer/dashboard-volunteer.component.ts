import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Volunteer } from 'src/app/shared/models/user/Volunteer';
import { AuthService } from 'src/app/shared/services/auth.service';
import { UserService } from 'src/app/shared/services/user.service';
import { VolunteerFilterService } from 'src/app/shared/services/volunteer-filter.service';
import { environment } from 'src/enviroments/enviroment';

@Component({
  selector: 'app-dashboard-volunteer',
  templateUrl: './dashboard-volunteer.component.html',
  styleUrls: ['./dashboard-volunteer.component.css']
})
export class DashboardVolunteerComponent implements OnInit {
  imageUrl: string | null = null;
  userData: any | null = null; // Variable para almacenar el nombre de usuario
  user: any;
  edit: Boolean = false;
  dataToken: any;
  agregaDesc: string = "Añade una descripcion";
  PersonalData: FormGroup;


  private apiURL = environment.apiURL; //Url


  userId?: number = 27;
  /* PersonalData Personal Data */

  userPhone?: string;

  constructor(
    private SVolunteer: VolunteerFilterService, 
    private authService: AuthService, 
    private http: HttpClient, 
    private formBuilder: FormBuilder, 
    private userService: UserService) {
    this.PersonalData = this.formBuilder.group({
      numberCellphone: [this.userPhone],
      id: [this.userId],
    })
  }

  get numberCellphone() {
    return this.PersonalData.get('phone');
  }

  get id(){
    return this.userId;
  }

  ngOnInit(): void {
    this.dataUserVolunteer();
  }

  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      // Crea un objeto URL para mostrar la imagen seleccionada
      this.imageUrl = URL.createObjectURL(file);
    }
  }

  dataUserVolunteer() {
    const token = localStorage.getItem('token');
    this.dataToken = token;
    const userDataRaw = this.authService.getUsernameFromToken();
    this.userData = userDataRaw;
    const { Id, rol } = this.userData;

    this.userService.getUserById(Id, this.dataToken).subscribe({
      next: (userData) => {
        this.user = userData;
        this.userId = this.user.id;
        console.log(this.user.numberCellphone + 'hola')
      },
      error: (error) => {
        console.error('Error al obtener el usuario:', error);
      }
    });
  }

  mix(){
    this.CancelEdit();
    this.SendPersonal();
  }
  SendPersonal() {
    const datos: Volunteer = {
      id: this.userData.id,
      firstName: this.userData.firstName,
      lastName: this.userData.lastName,
      email: this.userData.email,
      password: this.userData.password,//
      dni: this.userData.dni,
      dateOfBirth: this.userData.dateOfBirth,
      province: this.userData.province,
      locality: this.userData.locality,
      occupation: this.userData.occupation,
      numberCellphone: this.userData.numberCellphone,
      description: this.userData.description,
      avatar: this.userData.avatar,
      imageProfile: this.userData.imageProfile,
      skillList: this.userData.skillList
    };
    const token = localStorage.getItem('token');
    if (token) {
      const newURL = (`${this.apiURL}/volunteers/update`);
      this.SVolunteer.upadateVolunteer(this.PersonalData.value,token).subscribe(
        res => {
          console.log(res);
        }, (error) => {
          console.log(error);
        }
      );
    }
  }
  

  ActiveEdit(){
    const input = document.getElementById('email') as HTMLInputElement;
    input.disabled = false;
    this.edit = true
    console.log(this.edit);
    
  }

  CancelEdit(){
    const input = document.getElementById('email') as HTMLInputElement;
    input.disabled = true;
    this.edit = false;
    console.log('test');
    
  }

}
