import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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

  inputRequired = "Este campo es requerido";
  inputMinLength = "Este campo debe contener al menos 3 caracteres";
  inputMaxLength = "Este campo debe tener como máximo 18 caracteres";
  notNumberSpecial = "No se aceptan números ni caracteres especiales";

  confirmPassword = "";
  confirmEmail = "";


  patternPassword = '(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}';

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      userName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(18), Validators.pattern('^[A-Za-z ]+$')]],
      password: ['', Validators.required,
        Validators.pattern(this.patternPassword)
      ],
      confirmPassword: ['', Validators.required,
        Validators.pattern(this.patternPassword)],

      email: ['', Validators.required, Validators.email],
      confirmEmail: ['', Validators.required, Validators.email],
      tipeInstitution: ['', Validators.required],
      nameInstitution: ['', Validators.required, Validators.minLength(2), Validators.maxLength(18)],
      addressInstitution: ['', Validators.required],
      province: ['', Validators.required],
      locality: ['', Validators.required],
      numberPhone: ['', [Validators.required, Validators.pattern('^[+0-9]+$')]],
      timeAvailability: ['', Validators.required],
      services: ['', Validators.required]
    });
  }

  hasError(propertie: string, hasError: string): boolean {
    return this.form.get(propertie)!.touched && this.form.get(propertie)!.hasError(hasError);
  }

  saveInstitution() {
    this.form.markAllAsTouched();
    console.log("saveInstitution");
  }


  passwordConfirm() {
    return this.form.get('confirmPassword')!.touched && ((this.form.get('password')!.value !== this.form.get('confirmPassword')!.value));

  }

  emailConfirm() {
    return this.form.get('confirmEmail')!.touched && ((this.form.get('email')!.value !== this.form.get('confirmEmail')!.value));
  }
}
