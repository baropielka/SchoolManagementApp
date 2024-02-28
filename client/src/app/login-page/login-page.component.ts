import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AxiosService } from '../service/axios.service';
import { response } from 'express';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss', './../common/CommonStyles.scss']
})
export class LoginPageComponent {

  data: string[] = [];

  constructor(
    private axios: AxiosService,
    private router: Router
    ){};

  schoolName: string = 'Your School Name'

  loginForm: FormGroup = new FormGroup({
    login: new FormControl('', {
      nonNullable: true,
      updateOn: 'blur'
    }),
    password: new FormControl('', {
      nonNullable: true,
      updateOn: 'blur'
    })
  });

   onLoginClick(event: Event) {
    event.preventDefault();
    
    this.axios.request(
      'POST',
      '/login',
      {
        login: this.loginForm.get('login')?.value,
        password: this.loginForm.get('password')?.value,
      }
    );
  }
}
