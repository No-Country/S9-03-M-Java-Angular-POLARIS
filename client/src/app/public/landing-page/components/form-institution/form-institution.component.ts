import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-institution',
  templateUrl: './form-institution.component.html',
  styleUrls: ['./form-institution.component.css']
})
export class FormInstitutionComponent {

  form: FormGroup;
  showPassword: boolean = false

  inputRequired = "Este campo es requerido";
  inputMinLength = "Este campo debe contener al menos 3 caracteres";
  inputMaxLength = "Este campo debe tener como máximo 18 caracteres";
  notNumberSpecial = "No se aceptan números ni caracteres especiales";

  confirmPassword = "";

  patternPassword = '(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}';

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
  //    userName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(18), Validators.pattern('^[A-Za-z ]+$')]],
      nameInstitution: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(18)]],
      cuitInstitution: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.pattern(this.patternPassword)]],
      confirmPassword: ['', [Validators.required, Validators.pattern(this.patternPassword)]],
      email: ['', [Validators.required, Validators.email]],
      province: ['', Validators.required],
      locality: ['', Validators.required],
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

}
