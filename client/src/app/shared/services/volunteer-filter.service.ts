import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Skill } from '../enums/skill-enum';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Volunteer } from '../models/user/Volunteer';
import { environment } from 'src/enviroments/enviroment';

// Definimos un tipo que representa las claves del enum Skill
type SkillKey = keyof typeof Skill;
@Injectable({
  providedIn: 'root'
})
export class VolunteerFilterService {
  private url='https://polaris-backend.onrender.com/volunteers/'

  constructor(private http: HttpClient) { }
  private apiUrl = environment.apiURL;
  filterVolunterSkill(skill: string ,authToken: string){
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    return this.http.get(this.url + `getAllBySkillList/${skill}`, { headers });
  }

  upadateVolunteer(user: Volunteer, authToken:string){
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    return this.http.patch(this.apiUrl + '/volunteers/update', user, { headers });

  }

  getData(id:number){
    const reURL ='https://polaris-backend.onrender.com/reviews/'
    return this.http.get<any[]>(reURL + `${id}`);
  }
}

