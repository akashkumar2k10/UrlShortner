import { Injectable } from "@angular/core";
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";
import { Store, select } from "@ngrx/store";
import { Observable, tap } from "rxjs";
import { getUser, getUserEmail, isLogin } from "./auth.selector";
import { Tokens } from "./auth.models";

@Injectable({providedIn:'root'})
export class AuthGuard implements CanActivate{

    constructor(private store:Store,private router:Router,private aRouter:ActivatedRoute){

    }

    canActivate(_,state):Observable<boolean>{
        return this.store.pipe(
            select(isLogin),
            tap(loged => {
                let token:Tokens = JSON.parse(decodeURIComponent(localStorage.getItem('token')))
                if(loged) return;
                else this.router.navigateByUrl('')
            }),
        )
    }
    
}