import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CountryFormatServiceService {
  constructor() { }
  public countries: string[] = [
    'Perú',
    'Estados Unidos',
    'España',
    'Argentina',
    'Colombia',
    'México',
    'Chile',
    'Brasil',
    'Ecuador',
    'Alemania'
    // Agrega más países según sea necesario
  ];

  public countryFormats: { [key: string]: RegExp } = {
    'Perú': /^[0-9]{8}$/,
    'Estados Unidos': /^[0-9]{9}$/,
    'España': /^[0-9A-Z]{8}$/,
    'Argentina': /^[0-9]{7,8}$/,
    'Colombia': /^[0-9]{6,10}$/,
    'México': /^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$/,
    'Chile': /^[0-9]{8}$/,
    'Brasil': /^[0-9]{11}$/,
    'Ecuador': /^[0-9]{10}$/,
    'Alemania': /^[0-9A-Z]{9}$/
    // Agrega más países y formatos según sea necesario
  };

}
