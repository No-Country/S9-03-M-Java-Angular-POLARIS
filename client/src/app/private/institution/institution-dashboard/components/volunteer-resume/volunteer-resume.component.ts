import { Component, Input } from '@angular/core';
import { Volunteer } from 'src/app/shared/models/user/Volunteer';
import { UserService } from 'src/app/shared/services/user.service';
import { Skill } from 'src/app/shared/enums/skill-enum';


type SkillKey = keyof typeof Skill;

@Component({
  selector: 'app-volunteer-resume',
  templateUrl: './volunteer-resume.component.html',
  styleUrls: ['./volunteer-resume.component.css']
})
export class VolunteerResumeComponent {
  @Input() voluntaries: Volunteer[]=[];
  dataToken: any
  voluntarieSkills: Skill[]=[];

  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.volunteerList();
  }


  volunteerList(): void {
    const token = localStorage.getItem('token');
    this.dataToken=token;
    this.userService.getAllVoluntaries(this.dataToken).subscribe(data => { this.voluntaries = data });
  }

  mapSkillsToEnum(skills?: SkillKey[]): string[] {
    if (!skills) {
      return [];
    }
    return skills.map(skill => Skill[skill] || skill);
  }
}
