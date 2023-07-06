import { TestBed } from '@angular/core/testing';

import { CountryFormatServiceService } from './country-format-service.service';

describe('CountryFormatServiceService', () => {
  let service: CountryFormatServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CountryFormatServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
