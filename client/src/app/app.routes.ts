import { Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { SchoolDetailsComponent } from './school-details/school-details.component';

export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch:'full'},
    {path: 'login', component: LoginPageComponent},
    {path: 'main', component: MainPageComponent},
    {path: 'school', component: SchoolDetailsComponent},
    {path: '**', redirectTo: 'login', pathMatch:'full'}
];
