import { TestBed } from '@angular/core/testing';

import { VolunteerFilterService } from './volunteer-filter.service';

describe('VolunteerFilterService', () => {
  let service: VolunteerFilterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VolunteerFilterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
