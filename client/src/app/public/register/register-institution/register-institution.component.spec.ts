import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterInstitutionComponent } from './register-institution.component';

describe('RegisterInstitutionComponent', () => {
  let component: RegisterInstitutionComponent;
  let fixture: ComponentFixture<RegisterInstitutionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterInstitutionComponent]
    });
    fixture = TestBed.createComponent(RegisterInstitutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
