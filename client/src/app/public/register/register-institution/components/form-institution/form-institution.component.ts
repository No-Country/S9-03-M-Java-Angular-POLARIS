import { Component, OnInit,ViewChild  } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators,ValidatorFn, ValidationErrors  } from '@angular/forms';
import { CountryFormatServiceService } from 'src/app/public/landing-page/services/country-format-service.service';
import { MatStepper } from '@angular/material/stepper';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroments/enviroment';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-institution',
  templateUrl: './form-institution.component.html',
  styleUrls: ['./form-institution.component.css']
})
export class FormInstitutionComponent implements OnInit {
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  thirdFormGroup!: FormGroup;
  isEditable: boolean = false;
  showPassword: boolean = false;
  form!: FormGroup;

  patternCUIT = '/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i';
  patternPassword = '(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,}';

  private apiURL = environment.apiURL;


  @ViewChild('stepper') stepper!: MatStepper;

  constructor(private _formBuilder: FormBuilder, private http: HttpClient, private router: Router) {

    this.form = this._formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      cuit: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(15), this.cuitValidator]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(16), Validators.pattern(this.patternPassword)]],
      confirmPassword: ['', [Validators.required, Validators.pattern(this.patternPassword)]],
      province: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(30)]],
      locality: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(30)]]
    })

  }

  ngOnInit() {
    

  }

  onSubmit(){

    console.log(this.form.value);

    if(this.form.valid){
      
      const newURL = (`${this.apiURL}/auth/registerInstitution`);
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


  cuitValidator(control: AbstractControl): ValidationErrors | null {
    const cuit = control.value;

    if (!cuit) {
      return null; // Si el campo está vacío, no se realiza la validación
    }

    // Verificar que sea un número válido
    if (!/^\d+$/.test(cuit)) {
      return { cuitInvalid: true };
    }

    return null; // CUIT válido
  }
  
  
  onKeyPress(event: KeyboardEvent) {
    const inputChar = String.fromCharCode(event.keyCode);

    // Solo permitir caracteres numéricos y la tecla "borrar"
    if (!/^\d+$/.test(inputChar) && event.keyCode !== 11) {
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

  

  getDocumentPlaceholder(): string {
    const selectedCountry = this.secondFormGroup.get('country')?.value;
    return selectedCountry ? `Ingrese su ${this.getDocumentType(selectedCountry)}` : 'Ingrese su documento de identidad';
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
