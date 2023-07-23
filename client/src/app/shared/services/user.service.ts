import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'https://polaris-backend.onrender.com/volunteers/getById';
  constructor(private http: HttpClient) {}

    getUserById(userId: string, authToken: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    const url = `${this.apiUrl}/${userId}`;

    return this.http.get<any>(url, { headers }).pipe(
      catchError((error) => {
        // Aquí puedes manejar errores, si lo deseas.
        console.error('Error al obtener el usuario:', error);
        throw error;
      })
    );
  }

}
