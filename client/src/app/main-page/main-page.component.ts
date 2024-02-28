import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [],
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss', './../common/CommonStyles.scss']
})
export class MainPageComponent {

  constructor(private router: Router){}

  onSchoolDetailsClicked(event: Event){
    event.preventDefault();
    this.router.navigate(['/school']);
  }
}
