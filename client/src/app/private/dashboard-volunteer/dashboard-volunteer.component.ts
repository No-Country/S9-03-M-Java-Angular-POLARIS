import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
  selector: 'app-dashboard-volunteer',
  templateUrl: './dashboard-volunteer.component.html',
  styleUrls: ['./dashboard-volunteer.component.css']
})
export class DashboardVolunteerComponent implements OnInit {
  imageUrl: string | null = null;
  userData: any | null = null; // Variable para almacenar el nombre de usuario
  @Input() Institution: any[]=[];
  user:any;
  dataToken:any;
  startIndex = 0;
  endIndex = 2;
  
  constructor(private authService: AuthService,private userService: UserService) { }

  ngOnInit():void{
    this.dataUserVolunteer();
    this.institutionList();
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
      },
      error: (error) => {
        console.error('Error al obtener el usuario:', error);
      }
    });
  }
  institutionList():void{
    const token = localStorage.getItem('token');
    this.dataToken=token;
    this.userService.getInstutionAll(this.dataToken).subscribe(data => { this.Institution = data })
  }

  // Funciones para navegar entre los elementos
  showNextThree() {
    if (this.endIndex + 3 < this.Institution.length) {
      this.startIndex += 3;
      this.endIndex += 3;
    }
  }

  showPreviousThree() {
    if (this.startIndex - 3 >= 0) {
      this.startIndex -= 3;
      this.endIndex -= 3;
    }
  }
}
