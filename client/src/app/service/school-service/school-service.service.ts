import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SchoolDetailsSto } from '../../model/SchoolDetailsTo';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {

  constructor(private http: HttpClient) { }
  httpUrl = 'http://localhost:8080/schools';

  getSchoolInfo() {
    return this.http.get<SchoolDetailsSto>(this.httpUrl);
  }
}
