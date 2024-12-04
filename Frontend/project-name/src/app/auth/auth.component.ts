import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Store } from '@ngrx/store';
import { autoLogin, login } from './store/auth.actions';
import { apis } from '../app.apis';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent implements OnInit {
login() {
  window.open(apis.login,'_self')
}


  constructor(private store:Store){

  }

  ngOnInit(): void {
    if(localStorage.getItem('token')!=undefined) {this.store.dispatch(autoLogin())}
  }


  

  
}
