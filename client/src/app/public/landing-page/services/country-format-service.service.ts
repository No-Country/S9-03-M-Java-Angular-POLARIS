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
    'Argentina': /^\d{8}(-\d)?$/,
    'Colombia': /^\d{9}$|^\d{10}-\d{1}$/,
    'México': /^[A-Z]{4}\d{6}[HM][A-Z]{2}[A-Z\d]{2}[A-Z\d]{1}[A-Z\d]{1}\d{1}$/,
    'Chile': /^[0-9]{8}$/,
    'Brasil': /^\d{3}\.\d{3}\.\d{3}-\d{2}$/,
    'Ecuador': /^[0-9]{10}$/,
    'Alemania': /^[0-9A-Z]{9}$/
    // Agrega más países y formatos según sea necesario
  };

  public options = [
    { label: 'Baile', value: 'Baile' },
    { label: 'Tocar un instrumento musical', value: 'Tocar un instrumento musical' },
    { label: 'Escultura', value: 'Escultura' },
    { label: 'Cerámica', value: 'Cerámica' },
    { label: 'Tejido', value: 'Tejido' },
    { label: 'Deportes', value: 'Deportes' },
    { label: 'Escritura o narrativa', value: 'Escritura o narrativa' },
    { label: 'Cocina', value: 'Cocina' },
    { label: 'Juegos de mesa', value: 'Juegos de mesa' },
    { label: 'Idiomas', value: 'Idiomas' },
    { label: 'Yoya y meditación', value: 'Yoya y meditación' },
    { label: 'Computación con lectores de pantalla', value: 'Computación con lectores de pantalla' },
    { label: 'Arreglo de computadoras', value: 'Arreglo de computadoras' },
    { label: 'Artesano de maderas', value: 'Artesano de maderas' },
    { label: 'Canto', value: 'Canto' },
    { label: 'Otros', value: 'Otros' },
  ];

}
