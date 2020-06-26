import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular-service-router';
  constructor(private router: Router) {}
  gotoTimelines() {
    this.router.navigate(['/timelines']);
  }
}
