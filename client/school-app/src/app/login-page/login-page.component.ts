import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss'
})
export class LoginPageComponent {

  constructor(
    private http: HttpClient,
    private loginService: LoginService
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

   async onLoginClick(event: Event) {

    event.preventDefault();

    const formValues = this.loginForm.value;
    let credentials = {
      login: formValues.login,
      password: await this.loginService.hashPassword(formValues.password)
    };
    
    console.log(credentials);
    
  }
}
