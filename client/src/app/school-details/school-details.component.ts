import { Component, OnInit } from '@angular/core';
import { SchoolDetailsSto } from '../model/SchoolDetailsTo';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SchoolService } from '../service/school-service/school-service.service';

@Component({
  selector: 'app-school-details',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './school-details.component.html',
  styleUrls: [
    './school-details.component.scss',
    './../common/CommonStyles.scss',
  ],
})
export class SchoolDetailsComponent implements OnInit {
  httpUrl = 'http://localhost:8080/schools';

  constructor(private schoolService: SchoolService) {}

  editMode: boolean = false;

  schoolDetails!: SchoolDetailsSto;

  schoolDetaildForm: FormGroup = new FormGroup({
    name: new FormControl(),
    email: new FormControl(),
    phoneNumber: new FormControl(),
    schoolType: new FormControl(),
    street: new FormControl(),
    firstName: new FormControl(),
    lastName: new FormControl(),
  });

  ngOnInit(): void {
    this.schoolService.getSchoolInfo().subscribe((schoolDetails) => {
      this.schoolDetails = schoolDetails;
    });
  }

  onSaveClick(event: Event) {
    event.preventDefault();
    console.log('xD');
  }

  onEditClicked() {
    this, (this.editMode = !this.editMode);

    this.schoolDetaildForm.patchValue({
      name: this.schoolDetails.name,
      email: this.schoolDetails.email,
      phoneNumber: this.schoolDetails.phoneNumber,
      schoolType: this.schoolDetails.schoolType,
      street: this.schoolDetails.address.streetName,
      firstName: this.schoolDetails.headTeacher.firstName,
      lastName: this.schoolDetails.headTeacher.lastName,
    });
  }
}
