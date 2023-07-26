import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/auth.service';
import { UserService } from 'src/app/shared/services/user.service';
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
  dataToken: any;
  agregaDesc: string = "Añade una descripcion";
  PersonalData: FormGroup;

  private apiURL = environment.apiURL; //Url


  userId:number = this.userData.Id;
  /* PersonalData Personal Data */

  userPhone?: number;

  constructor(private authService: AuthService, private http: HttpClient, private formBuilder: FormBuilder, private userService: UserService) {
    this.PersonalData = this.formBuilder.group({
      phone: [this.userPhone],
    })
  }

  get phone() {
    return this.PersonalData.get('phone');
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
        console.log(this.user)
      },
      error: (error) => {
        console.error('Error al obtener el usuario:', error);
      }
    });
  }

  SendPersonal() {
    console.log(this.PersonalData.value)

    if (this.PersonalData.valid) {

      const newURL = (`${this.apiURL}/volunteers/update`);
      this.http.patch<any>(newURL, this.PersonalData.value).subscribe(
        (res) => {
          console.log(res);
        }, (error) => {
          console.log(error);
        }
      );
    }
  }

}
