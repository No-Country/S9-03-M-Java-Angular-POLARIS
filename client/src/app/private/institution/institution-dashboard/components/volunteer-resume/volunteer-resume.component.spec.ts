import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerResumeComponent } from './volunteer-resume.component';

describe('VolunteerResumeComponent', () => {
  let component: VolunteerResumeComponent;
  let fixture: ComponentFixture<VolunteerResumeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VolunteerResumeComponent]
    });
    fixture = TestBed.createComponent(VolunteerResumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
