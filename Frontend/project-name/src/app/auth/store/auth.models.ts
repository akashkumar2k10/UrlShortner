export interface AuthState {
    userId : number;
    user : User;
    isLogged:boolean,
    token:Tokens,
}

export interface Tokens {
    IdToken:string;
    AccessToken:string;
}

interface User {
    id: string;
    email: string;
    verified_email: boolean;
    name: string;
    given_name: string;
    family_name: string;
    picture: string;
    locale: string;
}