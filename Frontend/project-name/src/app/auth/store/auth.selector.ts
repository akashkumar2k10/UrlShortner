import { createFeatureSelector, createSelector } from "@ngrx/store"
import { AuthState } from "./auth.models"

export const selectAuthState = createFeatureSelector<AuthState>('auth');
export const getAccessToken = createSelector(selectAuthState,auth => auth?.token?.AccessToken);
export const getIdToken = createSelector(selectAuthState,auth => 
    auth?.token?.IdToken);
export const getUser = createSelector(selectAuthState,auth => auth?.user);
export const getUserEmail = createSelector(selectAuthState,auth => auth?.user?.email);
export const isLogin = createSelector(selectAuthState,auth => auth?.isLogged);
export const getProfilePic = createSelector(selectAuthState,auth => auth?.user?.picture);
