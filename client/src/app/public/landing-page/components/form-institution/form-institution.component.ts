import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DemandedService } from 'src/app/shared/enums/demanded-services-enum';
import { TimeAvailability } from 'src/app/shared/enums/time-availability-enum';
import { TypeInstitution } from 'src/app/shared/enums/type-institution-enum';

@Component({
  selector: 'app-form-institution',
  templateUrl: './form-institution.component.html',
  styleUrls: ['./form-institution.component.css']
})
export class FormInstitutionComponent {

  form: FormGroup;
  privada: string = TypeInstitution.PRIVADA;
  publica: string = TypeInstitution.PUBLICA;
  volunteer: string = DemandedService.VOLUNTEER;
  workshops: string = DemandedService.WORKSHOPS;
  service: string = DemandedService.SERVICE;
  other: string = DemandedService.OTHERS;
  morning = TimeAvailability.MORNING;
  afternoon = TimeAvailability.AFTERNOON;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      userName: [],
      passwords: [],
      confirmPassword: [],
      email: [],
      confirmEmail: [],
      tipeInstitution: [],
      nameInstitution: [],
      addressInstitution: [],
      province: [],
      locality: [],
      numberPhone: [],
      timeAvailability: [],
      services: []
    });
  }
}
