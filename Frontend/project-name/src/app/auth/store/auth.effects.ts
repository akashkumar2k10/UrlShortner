import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { AuthService } from '../../store/app.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import {
  autoLogin,
  autoLoginFailed,
  login,
  login_error,
  login_success,
  logout,
  redirectUrl,
  setLogoutFailed,
  setLogoutSuccess,
  setToken,
  setTokenSuccess,
  setUser,
  setUserFailed,
} from './auth.actions';
import {
  catchError,
  concatMap,
  map,
  of,
  switchMap,
  tap,
  withLatestFrom,
} from 'rxjs';
import { provideCloudinaryLoader } from '@angular/common';
import { getAccessToken, getIdToken } from './auth.selector';
import { Tokens } from './auth.models';

@Injectable()
export class AuthEffect {
  constructor(
    private action$: Actions,
    private apis: AuthService,
    private router: Router,
    private aRouter: ActivatedRoute,
    private store: Store
  ) {}

  setUser$ = createEffect(() => {
    return this.action$.pipe(
      ofType(setToken),
      concatMap((action) => {
        return of(action).pipe(
          withLatestFrom(this.store.select(getAccessToken))
        );
      }),
      switchMap(([payload, token]) => {
        return this.apis.getUserInfo(token).pipe(
          map((payload) => setUser({ payload })),
          catchError((payload) => of(setUserFailed({ payload })))
        );
      }),
      tap(() => {
        this.router.navigateByUrl('home');
      })
    );
  });

  logout$ = createEffect(() => {
    return this.action$.pipe(
      ofType(logout),
      concatMap((action) => {
        return of(action).pipe(
          withLatestFrom(this.store.select(getAccessToken))
        );
      }),
      switchMap(([payload, token]) => {
        return this.apis.logout(token).pipe(
          map((payload) => setLogoutSuccess({ payload })),
          catchError((payload) => of(setLogoutFailed({ payload })))
        );
      }),
      tap(() => {
        console.log('logout success');
      })
    );
  });

  afterLogout$ = createEffect(
    () => {
      return this.action$.pipe(
        ofType(setLogoutFailed, setLogoutSuccess),
        tap(() => {
          this.router.navigate(['/auth']);
        })
      );
    },
    { dispatch: false }
  );

  autoLogin$ = createEffect(() => {
    return this.action$.pipe(
      ofType(autoLogin),
      switchMap(() => {
        let token: Tokens = JSON.parse(
          decodeURIComponent(localStorage.getItem('token'))
        );
        return this.apis.getUserInfo(token.AccessToken).pipe(
          map((payload) => setToken({ payload: token })),
          catchError(() => of(autoLoginFailed()))
        );
      })
    );
  });

  autoLoginFailed$ = createEffect(
    () => {
      return this.action$.pipe(
        ofType(autoLoginFailed),
        tap(() => {
          alert('Please re-login');
        })
      );
    },
    { dispatch: false }
  );

  redirectUrl$ = createEffect(() => {
    return this.action$.pipe(
      ofType(redirectUrl),
      tap((action) => {
        return this.apis.redirectUrl(action.payload).pipe(map(() => {}));
      })
    );
  });

  // autoLogin$ = createEffect(()=>{
  //     return this.action$.pipe(
  //         ofType(autoLogin),
  //         switchMap(()=>{
  //             let token = JSON.parse(decodeURIComponent(localStorage.getItem('token')))
  //             return this.apis.getUserInfo(token.AccessToken).pipe(
  //                 map(payload => setUser({payload})),
  //                 catchError(payload => of(setUserFailed({payload}))),
  //             )

  //         })
  //     )
  // });
  // autoLogin$ = createEffect(()=>{
  //     return this.action$.pipe(
  //         ofType(autoLogin),
  //         map((action)=>{
  //             let token:Tokens = JSON.parse(decodeURIComponent(localStorage.getItem('token')))
  //             return setToken({payload:token});
  //         })
  //     )
  // });

  // login$ = createEffect(()=>{
  //     return this.action$.pipe(
  //         ofType(login),
  //         switchMap(()=>{
  //             return this.apis.login().pipe(
  //                 map(payload => login_success({payload})),
  //                 catchError(payload => of(login_error({payload}))),
  //             )
  //         })
  //     )
  // });
  // loginSuccess$ = createEffect(()=>{
  //     return this.action$.pipe(
  //         ofType(login_success),
  //         switchMap(({payload})=>{
  //             return this.apis.getUserInfo().pipe(
  //                 map(payload => setUser({payload})),
  //                 catchError(payload => of(setUserFailed({payload}))),
  //             )
  //         })
  //     )
  // });
}
