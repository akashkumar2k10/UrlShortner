import { createAction, props } from '@ngrx/store';
import { Tokens } from './auth.models';

export enum type {
  LOGIN = '[Auth] Login',
  LOGIN_SUCCESS = '[Auth] Login success',
  LOGIN_ERROR = '[Auth] Login error',
  SET_USER = '[Auth] SET USER',
  SET_USER_FAILED = '[Auth] SET USER FAILED',
  LOGOUT = '[Auth] LOGOUT',
  LOGOUT_SUCCESS = '[Auth] LOGOUT_SUCCESS',
  LOGOUT_FAILED = '[Auth] LOGOUT_FAILED',
  REMOVE_USER = '[Auth] REMOVE USER',
  SET_TOKEN = '[Auth] SET TOKEN',
  SET_TOKEN_SUCCESS = '[Auth] SET TOKEN SUCCESS',
  SET_TOKEN_FAILED = '[Auth] SET TOKEN FAILED',
  AUTO_LOGIN = '[Auth] AUTO LOGIN',
  AUTO_LOGIN_FAILED = '[Auth] AUTO LOGIN_FAILED',
  REDIRECT_URL = '[AUTH] REDIRECT_URL',
}

export const login = createAction(type.LOGIN);
export const login_success = createAction(
  type.LOGIN_SUCCESS,
  props<{ payload: any }>()
);
export const login_error = createAction(
  type.LOGIN_ERROR,
  props<{ payload: any }>()
);
export const logout = createAction(type.LOGOUT);
export const setLogoutSuccess = createAction(
  type.LOGOUT_SUCCESS,
  props<{ payload: any }>()
);
export const setLogoutFailed = createAction(
  type.LOGOUT_FAILED,
  props<{ payload: any }>()
);

export const setUser = createAction(type.SET_USER, props<{ payload: any }>());
export const setUserFailed = createAction(
  type.SET_USER_FAILED,
  props<{ payload: any }>()
);
export const setToken = createAction(
  type.SET_TOKEN,
  props<{ payload: Tokens }>()
);
export const setTokenSuccess = createAction(
  type.SET_TOKEN_SUCCESS,
  props<{ payload: any }>()
);
export const setTokenFailed = createAction(
  type.SET_TOKEN_FAILED,
  props<{ payload: any }>()
);
export const autoLogin = createAction(type.AUTO_LOGIN);

export const autoLoginFailed = createAction(type.AUTO_LOGIN_FAILED);

export const redirectUrl = createAction(
  type.REDIRECT_URL,
  props<{ payload: string }>()
);
