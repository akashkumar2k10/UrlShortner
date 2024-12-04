import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { getUser, getUserEmail } from '../auth/store/auth.selector';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private store:Store){
    
  }

  useremail$ = this.store.select(getUserEmail);
}

