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
  constructor(private http: HttpClient) { }
  private apiUrl = environment.apiURL;
  private selectedSkillsSubject: BehaviorSubject<SkillKey[]> = new BehaviorSubject<SkillKey[]>([]);
  selectedSkills$: Observable<SkillKey[]> = this.selectedSkillsSubject.asObservable();

  setSelectedSkills(skills: SkillKey[]): void {
    this.selectedSkillsSubject.next(skills);
  }

  upadateVolunteer(user: Volunteer, authToken:string){
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    return this.http.patch(this.apiUrl + '/volunteers/update', user, { headers });

  }
}
