import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerRegFormComponent } from './volunteer-reg-form.component';

describe('VolunteerRegFormComponent', () => {
  let component: VolunteerRegFormComponent;
  let fixture: ComponentFixture<VolunteerRegFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VolunteerRegFormComponent]
    });
    fixture = TestBed.createComponent(VolunteerRegFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
