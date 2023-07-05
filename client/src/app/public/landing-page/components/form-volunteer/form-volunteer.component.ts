import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-volunteer',
  templateUrl: './form-volunteer.component.html',
  styleUrls: ['./form-volunteer.component.css']
})
export class FormVolunteerComponent implements OnInit {
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;

  constructor(private _formBuilder: FormBuilder) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }

  saveFormData() {
    const formData = {
      name: this.firstFormGroup.value.firstCtrl,
      address: this.secondFormGroup.value.secondCtrl
    };
    console.log("data",formData)
  }
}
