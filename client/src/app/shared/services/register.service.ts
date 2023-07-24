import { Injectable } from '@angular/core';
import { environment } from 'src/enviroments/enviroment';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiURL = environment.apiURL;

  constructor(private http: HttpClient) { }

  newUser(newUserData: any){
    const formData = new FormData();

    formData.append('firstName', newUserData.firstName);
    formData.append('lastName', newUserData.lastName);
    formData.append('gender', newUserData.gender);
    formData.append('dni', newUserData.dni);
    formData.append('email', newUserData.email);
    formData.append('password', newUserData.password);
    formData.append('province', newUserData.province);
    formData.append('locality', newUserData.locality);

    const url = (`${this.apiURL}/auth/registerVolunteer`);
    return this.http.post<any>(url, formData);
  }


  newInstitution(newUserData: any){
    const formData = new FormData();

    formData.append('nameInstitution', newUserData.nameInstitution);
    formData.append('institutionCuit', newUserData.institutionuit);
    formData.append('writeYourEmail', newUserData.writeYourEmail);
    formData.append('password', newUserData.password);
    formData.append('confirmPassword', newUserData.confirmPassword);
    formData.append('province', newUserData.province);
    formData.append('localty', newUserData.localty);

    const url = (`${this.apiURL}/auth/registerIntitution`);
    return this.http.post<any>(url, formData);
  }
}
