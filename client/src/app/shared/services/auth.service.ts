import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import jwt_decode from 'jwt-decode';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://polaris-backend.onrender.com/auth/sign-in'; // La URL de tu backend de autenticación
  private isLogged = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient,private router: Router) {}

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
    console.log("data token",token);
    console.log("token data negado",!!token)
    return !!token && !this.isTokenExpired(token);
  }
  isAuthenticated$(): Observable<boolean>{
    if(this.isLoggedIn()){
      this.isLogged.next(true);
    }
    return this.isLogged.asObservable();
  }
  getUsernameFromToken(): string | null {
    const token = this.getToken();
    if (token) {
      try {
        const decodedToken: any = jwt_decode(token);
        console.log("data token",decodedToken)
        return decodedToken.Id;
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

  // onLogout(): void {
  //   // Eliminar el token del localStorage
  //   localStorage.removeItem('token');

  //   // Navegar a la página de inicio de sesión o la página de aterrizaje y limpiar la navegación
  //   this.router.navigate(['/'], { replaceUrl: true }).then(() => {
  //     window.history.replaceState(null, '', '/');
  //   });
  // }
}
