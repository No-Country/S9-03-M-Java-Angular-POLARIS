import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://polaris-backend.onrender.com/auth/sign-in'; // La URL de tu backend de autenticación

  constructor(private http: HttpClient) {}

  login(credentials: any) {
    console.log("service credenc",credentials)
    // Realizar la solicitud POST al backend para iniciar sesión con las credenciales
    return this.http.post<any>(this.apiUrl, credentials);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    // Verifica si el token existe y si no ha expirado
    return !!token && !this.isTokenExpired(token);
  }
  getUsernameFromToken(): string | null {
    const token = this.getToken();
    if (token) {
      try {
        const decodedToken: any = jwt_decode(token);
        console.log("data token",decodedToken)
        return decodedToken.email;
      } catch (error) {
        console.error('Error decoding token:', error);
        return null;
      }
    }
    return null;
  }

  isTokenExpired(token: string): boolean {
    const now = Date.now() / 1000;
    const tokenExpiration = jwt_decode<any>(token).exp;
    return tokenExpiration < now;
  }
}
