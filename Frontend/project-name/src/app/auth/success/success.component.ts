import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Tokens } from '../store/auth.models';
import { Store } from '@ngrx/store';
import { setToken } from '../store/auth.actions';
import { getUser } from '../store/auth.selector';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrl: './success.component.css'
})
export class SuccessComponent implements OnInit{

  constructor(private aRoutor:ActivatedRoute
    ,private store:Store
    ,private router:Router,
    ){

  }
  ngOnInit(): void {
    this.aRoutor.queryParamMap.subscribe(paramsMap => {
      // Convert ParamMap to JavaScript object
      const token :Tokens = {
        IdToken: '',
        AccessToken: ''
      };
      paramsMap.keys.forEach(key => {
        token[key] = paramsMap.get(key);
      });
      localStorage.setItem('token',encodeURIComponent(JSON.stringify(token)));
      this.store.dispatch(setToken({payload:token}));

      this.store.select(getUser).subscribe(user => {
        console.log("searching for user")
        if(user != null){
          this.router.navigateByUrl('home');
        }
      });
    });

  }



}
