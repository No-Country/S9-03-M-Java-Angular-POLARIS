import { Component, HostListener, OnDestroy, OnInit } from '@angular/core';
import { SubscriptionService } from './shared/services/subscription.service';
import { AuthService } from './shared/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy {
  constructor(private authService: AuthService, private subscriptionService: SubscriptionService) {}
  title = 'polaris';
  @HostListener('window:beforeunload', ['$event'])
  onBeforeUnload(event: any) {
    // Asegúrate de eliminar el token del localStorage cuando el usuario cierra la ventana o pestaña del navegador
    // Asegúrate de eliminar el token del localStorage solo si el usuario cierra sesión explícitamente
    if (!this.authService.isLoggedIn()) {
      localStorage.removeItem('token');
    }
  }
  //hols
  ngOnInit() {
    this.subscriptionService.subscribeToNavigationStart();
  }

  ngOnDestroy() {
    this.subscriptionService.unsubscribeFromNavigationStart();
  }
}
