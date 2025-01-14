import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import {
  catchError,
  concatMap,
  map,
  mergeMap,
  tap,
  withLatestFrom,
} from 'rxjs/operators';
import { CustomLinkService } from './custom-link.services';
import * as CustomLinkActions from './custom-link.actions';
import { Store } from '@ngrx/store';
import { getAccessToken, getIdToken } from '../../../auth/store/auth.selector';

@Injectable()
export class CustomLinkEffects {
  // loadLinks$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(LinkActions.loadLinks),
  //     withLatestFrom(getIdToken),
  //     concatMap(([token]) =>
  //       this.linkService.getLinks(token).pipe(
  //         map((links) => LinkActions.loadLinksSuccess({ links })),
  //         catchError((error) => of(LinkActions.loadLinksFailure({ error })))
  //       )
  //     )
  //   )
  // );

  loadLinks$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CustomLinkActions.loadLinks),
      withLatestFrom(this.store.select(getIdToken)),
      tap(([action, token]) => console.log('Token:', token)), // Logs the token
      concatMap(([action, token]) =>
        this.linkService.getLinks(token).pipe(
          map((links) => CustomLinkActions.loadLinksSuccess({ links })),
          catchError((error) =>
            of(CustomLinkActions.loadLinksFailure({ error }))
          )
        )
      )
    )
  );

  addLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CustomLinkActions.addLink),
      withLatestFrom(this.store.select(getIdToken)),
      mergeMap(([action, token]) =>
        this.linkService.addLink(action.link, token).pipe(
          map((link) => CustomLinkActions.addLinkSuccess({ link })),
          catchError((error) => of(CustomLinkActions.addLinkFailure({ error })))
        )
      )
    )
  );

  updateLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CustomLinkActions.updateLink),
      withLatestFrom(this.store.select(getIdToken)),
      mergeMap(([action, token]) =>
        this.linkService.updateLink(action.link, token).pipe(
          map((link) => CustomLinkActions.updateLinkSuccess({ link })),
          catchError((error) =>
            of(CustomLinkActions.updateLinkFailure({ error }))
          )
        )
      )
    )
  );

  deleteLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CustomLinkActions.deleteLink),
      withLatestFrom(this.store.select(getIdToken)),
      mergeMap(([action, token]) =>
        this.linkService.deleteLink(action.id, token).pipe(
          map(() => CustomLinkActions.deleteLinkSuccess({ id: action.id })),
          catchError((error) =>
            of(CustomLinkActions.deleteLinkFailure({ error }))
          )
        )
      )
    )
  );

  constructor(
    private actions$: Actions,
    private linkService: CustomLinkService,
    private store: Store
  ) {}
}
