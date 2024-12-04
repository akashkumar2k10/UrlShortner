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
import { LinkService } from './link.service';
import * as LinkActions from './link.actions';
import { Store } from '@ngrx/store';
import { getAccessToken, getIdToken } from '../../../auth/store/auth.selector';

@Injectable()
export class LinkEffects {
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
      ofType(LinkActions.loadLinks),
      withLatestFrom(this.store.select(getIdToken)),
      tap(([action, token]) => console.log('Token:', token)), // Logs the token
      concatMap(([action, token]) =>
        this.linkService.getLinks(token).pipe(
          map((links) => LinkActions.loadLinksSuccess({ links })),
          catchError((error) => of(LinkActions.loadLinksFailure({ error })))
        )
      )
    )
  );

  addLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LinkActions.addLink),
      withLatestFrom(this.store.select(getIdToken)),
      mergeMap(([action, token]) =>
        this.linkService.addLink(action.link, token).pipe(
          map((link) => LinkActions.addLinkSuccess({ link })),
          catchError((error) => of(LinkActions.addLinkFailure({ error })))
        )
      )
    )
  );

  updateLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LinkActions.updateLink),
      mergeMap((action) =>
        this.linkService.updateLink(action.link).pipe(
          map((link) => LinkActions.updateLinkSuccess({ link })),
          catchError((error) => of(LinkActions.updateLinkFailure({ error })))
        )
      )
    )
  );

  deleteLink$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LinkActions.deleteLink),
      mergeMap((action) =>
        this.linkService.deleteLink(action.id).pipe(
          map(() => LinkActions.deleteLinkSuccess({ id: action.id })),
          catchError((error) => of(LinkActions.deleteLinkFailure({ error })))
        )
      )
    )
  );

  constructor(
    private actions$: Actions,
    private linkService: LinkService,
    private store: Store
  ) {}
}
