import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Volunteer } from '../models/user/Volunteer';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrlUser = 'https://polaris-backend.onrender.com/volunteers/getById';
  private apiUrlInstitution = 'https://polaris-backend.onrender.com/institutions/getById';

  constructor(private http: HttpClient) {}

  getUserById(userId: string, authToken: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    const url = `${this.apiUrlUser}/${userId}`;

    return this.http.get<any>(url, { headers }).pipe(
      catchError((error) => {
        // Aquí puedes manejar errores, si lo deseas.
        console.error('Error al obtener el usuario:', error);
        throw error;
      })
    );
  }

  getInstitutionById(userId: string, authToken: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    const url = `${this.apiUrlInstitution}/${userId}`;

    return this.http.get<any>(url, { headers }).pipe(
      catchError((error) => {
        // Aquí puedes manejar errores, si lo deseas.
        console.error('Error al obtener el usuario:', error);
        throw error;
      })
    );
  }


  getAllVoluntaries(authToken: string):Observable<Volunteer[]>{
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });
    const url = 'https://polaris-backend.onrender.com/volunteers/getAll';

    return this.http.get<Volunteer[]>(url,{headers}).pipe(
      catchError((error) => {
        console.error('Error al obtener el listado de voluntarios:', error);
        throw error;
      })
      );
  }

  getInstutionAll(authToken: string):Observable<any[]>{
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });
    const url = 'https://polaris-backend.onrender.com/institutions/getAll';

    return this.http.get<any[]>(url,{headers}).pipe(
      catchError((error) => {
        console.error('Error al obtener el listado de voluntarios:', error);
        throw error;
      })
      );
  }
}
