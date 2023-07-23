import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  showNavbar: boolean = true;
  userData: any | null = null; // Variable para almacenar el nombre de usuario
  user:any;
  dataToken:any;
  constructor(private router: Router, private authService: AuthService,private userService: UserService) { }

  ngOnInit():void{
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Verifica la URL actual y oculta el navbar en la página de inicio de sesión (login)
        this.showNavbar = this.router.url !== '/login';
        // Si el usuario ha iniciado sesión, obtén su nombre de usuario desde el token
        if (this.showNavbar && this.authService.isLoggedIn()) {
            const userDataRaw= this.authService.getUsernameFromToken() ;
            this.userData=userDataRaw;
            const {Id,rol} = this.userData;
            console.log("paisana jacinta",rol)
            const token = localStorage.getItem('token');
            this.dataToken=token;
            if(this.userData && token){
              if(rol==="Volunteer"){
                this.userService.getUserById(Id, token).subscribe({
                  next: (userData) => {
                    this.user = userData;
                    console.log("volunterrr",this.user)
                  },
                  error: (error) => {
                    console.error('Error al obtener el usuario:', error);
                  }
                });
              }
              else if(rol==="Institution"){
                console.log("al fondo hay sitio")
                this.userService.getInstitutionById(Id, token).subscribe({
                  next: (userData) => {
                    this.user = userData;
                    console.log("al fondo hay sitio",this.user.name)
                  },
                  error: (error) => {
                    console.error('Error al obtener el usuario:', error);
                  }
                });
              }
            }
            // console.log("username",this.username)
        }
      }
    });
  }
  logout(){
    this.onLogout();
  }

  onLogout(): void {
    // Eliminar el token del localStorage
    localStorage.removeItem('token');
  
    // Navegar a la página de inicio de sesión o la página de aterrizaje y limpiar la navegación
    this.router.navigate(['/'], { replaceUrl: true }).then(() => {
      window.history.replaceState(null, '', '/');
  
      // Usar setTimeout para asegurarse de que los datos se restablezcan antes de la detección de cambios
      setTimeout(() => {
        this.user = null;
        this.dataToken = null;
      });
    });
  }
  login(){
    this.router.navigateByUrl("/login");
  }
  inicio(){
    this.router.navigateByUrl('');
  }
  
}
