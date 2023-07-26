import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Institution } from '../models/user/Institution';

@Injectable({
  providedIn: 'root'
})
export class InstitutionService {

  private url='https://polaris-backend.onrender.com/institutions/'

  constructor(private http: HttpClient) { }

  updateInstitucion(datosActualizados: any,authToken: string){
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${authToken}`
    });

    return this.http.patch(this.url + 'update', datosActualizados, { headers });
  }
}
