import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormVolunteerComponent } from './form-volunteer.component';

describe('FormVolunteerComponent', () => {
  let component: FormVolunteerComponent;
  let fixture: ComponentFixture<FormVolunteerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormVolunteerComponent]
    });
    fixture = TestBed.createComponent(FormVolunteerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
