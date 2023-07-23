import { Injectable, inject } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs';
import { take, tap } from 'rxjs/operators';


export const authGuard = (): Observable<boolean> => {
  const authService: AuthService = inject(AuthService);
  const router: Router = inject(Router);

  return authService.isAuthenticated$().pipe(
    take(1),
    tap((isLoggedIn) => {
      if (!isLoggedIn) {
        router.navigate(['/']); // Redireccionar al inicio si el usuario no está autenticado
      }
    })
  );
};