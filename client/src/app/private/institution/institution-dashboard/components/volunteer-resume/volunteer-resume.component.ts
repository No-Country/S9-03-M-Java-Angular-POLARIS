import { Component } from '@angular/core';
import { Volunteer } from 'src/app/shared/models/user/Volunteer';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
  selector: 'app-volunteer-resume',
  templateUrl: './volunteer-resume.component.html',
  styleUrls: ['./volunteer-resume.component.css']
})
export class VolunteerResumeComponent {

  voluntaries: Volunteer[]=[];
  dataToken: any

  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.volunteerList();
  }


  volunteerList(): void {
    const token = localStorage.getItem('token');
    this.dataToken=token;
    this.userService.getAllVoluntaries(this.dataToken).subscribe(data => { this.voluntaries = data });
  }

}
