import { ActionReducerMap } from "@ngrx/store";
import { AuthState } from "../auth/store/auth.models";
import { authReducer } from "../auth/store/auth.reducer";

export interface AppState{
    auth:AuthState
}

export const appReducer : ActionReducerMap<AppState>={
    auth:authReducer
}