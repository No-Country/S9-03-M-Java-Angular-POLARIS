import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn  } from '@angular/forms';
import { CountryFormatServiceService } from '../../services/country-format-service.service';
import { MatStepper } from '@angular/material/stepper';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/shared/services/user.service';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/shared/services/register.service';
import Swal from 'sweetalert2';
import { environment } from 'src/enviroments/enviroment';

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
  form!: FormGroup;

  patternDNI = '^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$';
  patternPassword = '(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}';
  generoOptions = [
    { label: 'Hombre', value: 'Hombre'},
    { label: 'Mujer', value: 'Mujer'},
    { label: 'Otro', value: 'Otro'},
  ];

  private apiURL = environment.apiURL;


  @ViewChild('stepper') stepper!: MatStepper;

  constructor(private _formBuilder: FormBuilder,private countryFormatService: CountryFormatServiceService, private http: HttpClient, private register: RegisterService, private router: Router) {

    this.form = this._formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      lastName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      gender: ['', [Validators.required]],
      dni: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(9)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(16), Validators.pattern(this.patternPassword)]],
      confirmPassword: ['', [Validators.required, Validators.pattern(this.patternPassword)]],
      province: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      locality: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(30)]]
    })

  }

  ngOnInit() {
    

  }

  

  onSubmit(){
    /*if(this.form){
      this.register.newUser(this.form.value).subscribe(
        (res: any) => {
          console.log(this.form.value);
          console.log(res);
          
          
          alert('Usuario creado correctamente');
          this.router.navigate(['/login']);
        }
      )
    }else{
      alert('Error');
    }*/
    //console.log(this.form.value);

    if(this.form.valid){
      const newURL = (`${this.apiURL}/auth/registerVolunteer`);
      this.http.post<any>(newURL, this.form.value).subscribe(
        (res) => {
          console.log(res);
        }, (error) => {
          console.log(error);
        }
      );

      this.msgAlert('success', 'Cuenta creada con éxito');
      this.router.navigate(['/login']);
    }else{
      this.msgAlert('error', 'Error al crear cuenta');
    }
    
    
  }
  
  onKeyPress(event: KeyboardEvent) {
    const inputChar = String.fromCharCode(event.keyCode);

    // Solo permitir caracteres numéricos y la tecla "borrar"
    if (!/^\d+$/.test(inputChar) && event.keyCode !== 8) {
      event.preventDefault();
    }
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

  // alerta con sweetAlert
  msgAlert = (icon: any, title: any) =>{

    const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
      }

    })

    Toast.fire({
      icon: icon,
      title: title
    })
  }
}