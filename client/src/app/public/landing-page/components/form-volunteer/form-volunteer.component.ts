import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn, FormControl,FormArray   } from '@angular/forms';
import { CountryFormatServiceService } from '../../services/country-format-service.service';
import { MatStepper } from '@angular/material/stepper';
import { MatDatepicker } from '@angular/material/datepicker';

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
  phoneNumberPlaceholder: string = 'Número de celular';
  selectedCountryCode!: string;
  skillsHobbiesArray!: FormArray;
  dataSkillsHobbies!:string[];
  form!: FormGroup;

  patternDNI = '/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i';
  patternPassword = '(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}';

  @ViewChild('stepper') stepper!: MatStepper;
  @ViewChild('datePicker') datePicker!: MatDatepicker<Date>;



  constructor(private _formBuilder: FormBuilder,private countryFormatService: CountryFormatServiceService) {

    this.form = this._formBuilder.group({
      nameUser: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      userDNI: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(11), Validators.pattern(this.patternDNI)]],
      writeYourEmail: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(16), Validators.pattern(this.patternPassword)]],
      confirmPassword: ['', [Validators.required, Validators.pattern(this.patternPassword)]],
      province: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      locality: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(30)]]
    })

  }

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
      documentNumber: ['', Validators.required],
      address: ['', Validators.required],
      location: ['', Validators.required],
      province: ['', Validators.required],
      country: ['', Validators.required],
      codeCelphone: ['', Validators.required],
      cellphoneNumber: ['', Validators.required],
    });

    
    this.thirdFormGroup = this._formBuilder.group({
      timeAvailability: ['', Validators.required],
      profession: ['', Validators.required],
      skillsHobbies: [[], Validators.required],
    });

  }

  isSelected(option: any): boolean {
    const selectedOptions = this.thirdFormGroup.get('skillsHobbies')?.value;
    return selectedOptions && selectedOptions.includes(option.value);
  }
  
  toggleOption(option: any): void {
    this.dataSkillsHobbies=[...this.thirdFormGroup.get('skillsHobbies')?.value];
  }



  validarDNI(dni: string): boolean {
    const dniRegex = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;
  
    // Verificar que el DNI cumpla con el formato de 8 dígitos seguido de una letra (mayúscula o minúscula)
    if (!dniRegex.test(dni)) {
      return false;
    }
  
    // Extraer los dígitos y la letra del DNI
    const numerosDNI = dni.slice(0, -1);
    const letraDNI = dni.slice(-1).toUpperCase();
  
    // Calcular la letra correspondiente a los dígitos
    const letrasValidas = 'TRWAGMYFPDXBNJZSQVHLCKE';
    const letraCalculada = letrasValidas[parseInt(numerosDNI) % 23];
  
    // Verificar que la letra calculada coincida con la letra del DNI
    return letraDNI === letraCalculada;
  }

  passwordConfirm() {
    return this.form.get('confirmPassword')!.touched && ((this.form.get('password')!.value !== this.form.get('confirmPassword')!.value));
  }

  get countriesData(){
    return [...this.countryFormatService.countries];
  }

  get dataSkillHobbies(){
    return [...this.countryFormatService.options]
  }

  openDatePicker() {
    this.datePicker.open();
  }


  getDocumentPlaceholder(): string {
    const selectedCountry = this.secondFormGroup.get('country')?.value;
    return selectedCountry ? `Ingrese su ${this.getDocumentType(selectedCountry)}` : 'Ingrese su documento de identidad';
  }
  

  getDocumentPattern(): string | RegExp | null {
    const selectedCountry = this.secondFormGroup.get('country')?.value;
    const format = this.getDocumentFormatByCountry(selectedCountry);
    return format || null;
  }
  getDocumentFormatByCountry(country: string): RegExp | undefined {
    return this.countryFormatService.countryFormats[country];
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
      case 'México':
        return 'CURP (Ej: LOPE900101HDFRNR04)'
      // Resto de los casos
      default:
        return 'documento de identidad';
    }
  }

  get documentControl(): FormControl {
    return this.secondFormGroup.get('documentNumber') as FormControl;
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
    console.log("data info selec",this.dataSkillsHobbies);
    const formData = {...this.firstFormGroup.value,...this.secondFormGroup.value};

    console.log('Datos del formulario:', formData);

    // Restablecer los valores del formulario
    this.firstFormGroup.reset();
    this.secondFormGroup.reset();

    // Reiniciar el stepper
    this.stepper.reset();
  }



  get documentNumberControl(): AbstractControl | null {
    const documentNumberControl = this.secondFormGroup.get('documentNumber');
    const documentNumberValue = documentNumberControl?.value;
    const documentPattern = this.getDocumentPattern();
  
    if (documentNumberValue && documentPattern) {
      const regex = new RegExp(documentPattern);
      const isMatch = regex.test(documentNumberValue);
  
      if (!isMatch) {
        documentNumberControl?.setErrors({ pattern: true });
      }
    }
  
    return documentNumberControl;
  }


}
