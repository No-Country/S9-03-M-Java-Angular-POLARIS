import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionRegFormComponent } from './institution-reg-form.component';

describe('InstitutionRegFormComponent', () => {
  let component: InstitutionRegFormComponent;
  let fixture: ComponentFixture<InstitutionRegFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstitutionRegFormComponent]
    });
    fixture = TestBed.createComponent(InstitutionRegFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
