import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Skill } from '../enums/skill-enum';


// Definimos un tipo que representa las claves del enum Skill
type SkillKey = keyof typeof Skill;
@Injectable({
  providedIn: 'root'
})
export class VolunteerFilterService {
  private selectedSkillsSubject: BehaviorSubject<SkillKey[]> = new BehaviorSubject<SkillKey[]>([]);
  selectedSkills$: Observable<SkillKey[]> = this.selectedSkillsSubject.asObservable();

  setSelectedSkills(skills: SkillKey[]): void {
    this.selectedSkillsSubject.next(skills);
  }
}
