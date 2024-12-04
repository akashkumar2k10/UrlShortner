import { Component } from '@angular/core';
import {defaultNacList} from './nav-bar.constants';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { getProfilePic } from '../../auth/store/auth.selector';
import { login, logout } from '../../auth/store/auth.actions';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {
handleHome() {
  this.router.navigateByUrl(this.home);
}
  constructor(private router:Router,private store:Store){

  }
  home = "home/dashborad";
  navList = defaultNacList;
  profilePic$ = this.store.select(getProfilePic);

  handleClick(path:string){
    this.router.navigateByUrl(path);
  }

  logout(){
    this.store.dispatch(logout());

  }
}
