import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';
import { CountryFormatServiceService } from '../../services/country-format-service.service';
import { MatStepper } from '@angular/material/stepper';

@Component({
  selector: 'app-form-volunteer',
  templateUrl: './form-volunteer.component.html',
  styleUrls: ['./form-volunteer.component.css'],
})
export class FormVolunteerComponent implements OnInit {
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  thirdFormGroup!: FormGroup;
  isEditable: boolean = false;
  showPassword: boolean = false;
  @ViewChild('stepper') stepper!: MatStepper;

  constructor(private _formBuilder: FormBuilder,private countryFormatService: CountryFormatServiceService) {}

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
      Sex:['', Validators.required],
      birthdate: ['', Validators.required],
      documentNumber: ['', [Validators.required, Validators.pattern('')]],
      address: ['', Validators.required],
      location: ['', Validators.required],
      province: ['', Validators.required],
      country: ['', Validators.required],
      cellphoneNumber: ['', Validators.required],
    });
    
    this.thirdFormGroup = this._formBuilder.group({
      timeAvailability: ['', Validators.required],
      profession: ['', Validators.required],
      skillsHobbies: ['', Validators.required],
    });

  }
  get countriesData(){
    return [...this.countryFormatService.countries];
  }
  getDocumentFormatByCountry(country: string): RegExp | undefined {
    return this.countryFormatService.countryFormats[country];
  }

  getDocumentPlaceholder(): string {
    const selectedCountry = this.secondFormGroup.get('country')?.value;
    return selectedCountry ? `Ingrese su ${this.getDocumentType(selectedCountry)}` : 'Ingrese su documento de identidad';
  }

  getDocumentPattern(): string | null {
    const selectedCountry = this.secondFormGroup.get('country')?.value;
    const format = this.countryFormatService.countryFormats[selectedCountry];
    return format ? format.source : null;
  }
  getDocumentType(country: string): string {
    switch (country) {
      case 'Perú':
        return 'DNI';
      case 'Estados Unidos':
        return 'número de seguro social';
      case 'España':
        return 'DNI o NIE';
      case 'Argentina':
        return 'DNI';
      case 'Colombia':
        return 'cédula';
      // Resto de los casos
      default:
        return 'documento de identidad';
    }
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

  resetFormAndSaveData() {
    // Guardar los datos del formulario
    const formData = {...this.firstFormGroup.value,...this.secondFormGroup.value};

    console.log('Datos del formulario:', formData);

    // Restablecer los valores del formulario
    this.firstFormGroup.reset();
    this.secondFormGroup.reset();

    // Reiniciar el stepper
    this.stepper.reset();
  }
}
