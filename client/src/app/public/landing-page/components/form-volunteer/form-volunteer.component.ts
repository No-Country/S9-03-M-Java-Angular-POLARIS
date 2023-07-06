import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';

@Component({
  selector: 'app-form-volunteer',
  templateUrl: './form-volunteer.component.html',
  styleUrls: ['./form-volunteer.component.css']
})
export class FormVolunteerComponent implements OnInit {
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  isEditable: boolean = false;
  showPassword: boolean = false;


  constructor(private _formBuilder: FormBuilder) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      nameUser: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      writeYourEmail: ['', [Validators.required, Validators.email]],
      typeUser: ['', Validators.required],
      nameUsernameUser:['', Validators.required],
    }, {
      validators: this.passwordMatchValidator
    });

    this.secondFormGroup = this._formBuilder.group({
      birthdate: ['', Validators.required],
      documentNumber: ['', Validators.required],
      address: ['', Validators.required],
      location: ['', Validators.required],
      province: ['', Validators.required],
      country: ['', Validators.required],
      cellphoneNumber: ['', Validators.required],
    });
  }

  saveFormData() {
    if (this.firstFormGroup.valid && this.secondFormGroup.valid) {
      // Realizar acciones con los datos del formulario
      console.log('Datos del primer formulario:', this.firstFormGroup.value);
      console.log('Datos del segundo formulario:', this.secondFormGroup.value);
    } else {
      // Mostrar mensajes de error o tomar acciones adicionales
      console.log('Formulario inválido. Revisa los campos.');
      this.markAllAsTouched();
    }
  }
  toggleEditMode() {
    this.isEditable = !this.isEditable;
  }
  markAllAsTouched() {
    this.markFormFieldsAsTouched(this.firstFormGroup);
    this.markFormFieldsAsTouched(this.secondFormGroup);
  }

  markFormFieldsAsTouched(formGroup: FormGroup) {
    Object.values(formGroup.controls).forEach(control => {
      control.markAsTouched();
    });
  }

  togglePasswordVisibility() {
    this.showPassword = !this.showPassword;
  }

  passwordMatchValidator(control: AbstractControl): { [key: string]: any } | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;

    return password === confirmPassword ? null : { passwordMismatch: true };
  }
}
