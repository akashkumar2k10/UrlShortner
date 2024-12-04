import { createReducer, on } from "@ngrx/store";
import { AuthState } from "./auth.models";
import *  as AuthActions  from "./auth.actions";


const initialState : AuthState={
    userId: 0,
    user: null,
    isLogged: false,
    token:null,
}

export const authReducer = createReducer(
    initialState,
    on(AuthActions.setToken,(state,{payload})=>{
        return {
            ...state,
            isLogged:true,
            token:payload
        }
    }),
    on(AuthActions.setUser,(state,{payload})=>{
        //console.log("from Reduser",payload)
        return {
            ...state,
            user:payload
        }
    }),

    // on(AuthActions.login,(state,{payload})=>{
    //    return{
    //        ...state,
    //         isLogged:true,
    //         userName:payload
    //    } 
    // }),
    on(AuthActions.setLogoutSuccess,(state)=>{
       return{
        ...initialState,

       } 
    }),
    on(AuthActions.setLogoutFailed,(state)=>{
       return{
        ...initialState,

       } 
    }),


    
)
