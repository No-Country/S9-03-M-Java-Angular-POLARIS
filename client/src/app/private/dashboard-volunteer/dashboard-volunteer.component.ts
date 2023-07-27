import { HttpClient } from '@angular/common/http';
import { Component, OnInit,Input } from '@angular/core';
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
  @Input() Institution: any[]=[];
  user:any;
  dataToken:any;
  startIndex = 0;
  endIndex = 2;
  edit: Boolean = false;
  agregaDesc: string = "Añade una descripcion";
  PersonalData: FormGroup;

  OtrosSkill:string = 'Otros';
  private apiURL = environment.apiURL; //Url


  userId?: number;
  // Skills

  selectedSkills: any[] = []; // Para mantener las habilidades seleccionadas
  availableSkills: string[] = [
    'Taller de Arte',
    'Lenguaje de Señas',
    'Deportes',
    'Taller de Lectura',
    'Yoga y Meditación',
    'Idiomas',]

  userSkills?:string;

  /* PersonalData Form */

  userPhone?: string;
  userEducation?: string;
  userAvailability?: string;
  userDescription?: string;

  constructor(
    private SVolunteer: VolunteerFilterService,
    private authService: AuthService,
    private http: HttpClient,
    private formBuilder: FormBuilder,
    private userService: UserService) {
    this.PersonalData = this.formBuilder.group({
      id: [this.userId],
      numberCellphone: [this.userPhone],
      education: [this.userEducation],
      availability: [this.userAvailability],
      description: [this.userDescription]
    })
  }

  get numberCellphone() {
    return this.PersonalData.get('phone');
  }

  get education() {
    return this.PersonalData.get('education');
  }

  get availability() {
    return this.PersonalData.get('availability');
  }

  get id() {
    return this.userId;
  }

  get description(){
    return this.PersonalData.get('description');
  }

  ngOnInit(): void {
    this.dataUserVolunteer();
    this.institutionList();
  }

  isSkillSelected(skill: string): boolean {
    
    
    return this.user.skillList.includes(this.Conversor(skill));
  }
  
  onSkillCheckboxChange(skill: string, event: any) {
    if (event.target.checked) {
      if (!this.selectedSkills.includes(skill)) {
        this.user.skillList.push(skill);
        console.log(this.user.skillList);
        
      }
    } else {
      const index = this.selectedSkills.indexOf(skill);
      if (index !== -1) {
        this.selectedSkills.splice(index, 1);
      }
    }
  }

  Conversor(skill:string){
    switch (skill) {
      case 'Taller de Arte':
        return 'TALLER_DE_ARTE';
      case 'Lenguaje de Señas':
        return 'LENGUAJE_DE_SEÑAS';
      case 'Deportes':
        return 'DEPORTES';
      case 'Taller de Lectura':
        return 'TALLER_DE_LECTURA';
      case 'Yoga y Meditación':
        return 'YOGA_Y_MEDITACION';
      case 'Idiomas':
        return 'IDIOMAS';
      case 'Otros':
        return 'OTROS'

        default:
          return '';
    }
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
        
        console.log(this.selectedSkills);
        
        console.log(this.user.numberCellphone + 'hola')
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

  

  mix() {
    this.CancelEdit();
    this.SendPersonal();
  }
  SendPersonal() {
    const storedSelectedSkills = localStorage.getItem('selectedSkills');
  if (storedSelectedSkills) {
    this.selectedSkills = JSON.parse(storedSelectedSkills);
  }

    const datos: Volunteer = {
      id: this.user.id,
      firstName: this.user.firstName,
      lastName: this.user.lastName,
      email: this.user.email,//
      dni: this.user.dni,
      province: this.user.province,
      locality: this.user.locality,
      availability: this.user.availability,
      numberCellphone: this.user.numberCellphone,
      description: this.user.description,
      avatar: this.user.avatar,
      otherSkills: this.user.skillList,
      imageProfile: this.user.imageProfile,
      skillList: this.user.skillList
    };
    const token = localStorage.getItem('token');
    if (token) {
      const newURL = (`${this.apiURL}/volunteers/update`);
      this.SVolunteer.upadateVolunteer(this.user, token).subscribe(
        res => {
          console.log(res);
        }, (error) => {
          console.log(error);
        }
      );
    }
  }


  ActiveEdit() {
    const input = document.getElementById('email') as HTMLInputElement;
    input.disabled = false;
    this.edit = true
    console.log(this.edit);

  }

  CancelEdit() {
    const input = document.getElementById('email') as HTMLInputElement;
    input.disabled = true;
    this.edit = false;
    console.log('test');

  }

}
