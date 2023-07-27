import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Skill } from '../enums/skill-enum';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Volunteer } from '../models/user/Volunteer';


// Definimos un tipo que representa las claves del enum Skill
type SkillKey = keyof typeof Skill;
@Injectable({
  providedIn: 'root'
})
export class VolunteerFilterService {
  private url='https://polaris-backend.onrender.com/volunteers/'

  constructor(private http: HttpClient) { }

  filterVolunterSkill(skill: string ,authToken: string){
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    return this.http.get(this.url + `getAllBySkillList/${skill}`, { headers });
  }
}

