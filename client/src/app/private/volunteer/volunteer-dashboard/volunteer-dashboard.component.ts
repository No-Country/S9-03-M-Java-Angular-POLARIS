import { Component } from '@angular/core';
import { UserService } from '../../../shared/services/user.service';
import { AuthService } from 'src/app/shared/services/auth.service';

@Component({
  selector: 'app-volunteer-dashboard',
  templateUrl: './volunteer-dashboard.component.html',
  styleUrls: ['./volunteer-dashboard.component.css']
})
export class VolunteerDashboardComponent{
  imageUrl: string | null = null;
  userData: any | null = null; // Variable para almacenar el nombre de usuario
  user:any;
  dataToken:any;

  constructor(private authService: AuthService,private userService: UserService) { }
  ngOnInit():void{
    this.dataUserVolunteer();
  }
  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      // Crea un objeto URL para mostrar la imagen seleccionada
      this.imageUrl = URL.createObjectURL(file);
    }
  }
  dataUserVolunteer(){
    const token = localStorage.getItem('token');
    this.dataToken=token;
    const userDataRaw= this.authService.getUsernameFromToken() ;
    this.userData=userDataRaw;
    const {Id,rol} = this.userData;

    this.userService.getUserById(Id, this.dataToken).subscribe({
      next: (userData) => {
        this.user = userData;
        console.log("volunterrr",this.user)
      },
      error: (error) => {
        console.error('Error al obtener el usuario:', error);
      }
    });
  }
}
