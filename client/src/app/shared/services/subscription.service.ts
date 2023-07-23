import { Injectable } from '@angular/core';
import { Router, NavigationStart, Event } from '@angular/router';
import { AuthService } from './auth.service';
import { Subscription } from 'rxjs';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {
  private navigationSubscription?: Subscription;

  constructor(private authService: AuthService, private router: Router) {}

  private isAuthenticated(): boolean {
    // Aquí puedes implementar la lógica para verificar si el usuario está autenticado
    // Por ejemplo, puedes verificar si el token existe en el localStorage o si hay una sesión activa en el servidor
    return this.authService.isLoggedIn();
  }

  private handleNavigationStart(event: Event): void {
    if (this.isAuthenticated() && event instanceof NavigationStart && event.navigationTrigger === 'popstate') {
      // Si el usuario está autenticado y la navegación fue causada por el evento 'popstate'
      // Redireccionar nuevamente a la ruta /user para evitar el retroceso del navegador
      const token = localStorage.getItem('token');
      if (token) {
        const decodedToken: any = jwt_decode(token); // Decodificar el token
        const expirationDate = new Date(decodedToken.exp * 1000); // Convertir la fecha de expiración a milisegundos
        // Comparar la fecha de expiración con la fecha actual
        if (expirationDate > new Date()) {
          const userRole = decodedToken.rol;
          if (userRole === 'Volunteer') {
            this.router.navigateByUrl('/user', { skipLocationChange: true });
            this.router.navigate(['/user']);
          } else if (userRole === 'Institución') {
            this.router.navigateByUrl('/dashboard-institution', { skipLocationChange: true });
            this.router.navigate(['/dashboard-institution']);
          }
        }
        else{
            // El token ha expirado, eliminarlo del localStorage
            localStorage.removeItem('token');
            this.router.navigate(['/']);
        }
      }
    }
  }

  subscribeToNavigationStart(): void {
    this.navigationSubscription = this.router.events.subscribe((event: Event) => {
      this.handleNavigationStart(event);
    });
  }

  unsubscribeFromNavigationStart(): void {
    if (this.navigationSubscription) {
      this.navigationSubscription.unsubscribe();
    }
  }
}