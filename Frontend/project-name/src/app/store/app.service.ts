import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { apis } from '../app.apis';
import { map } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(private http: HttpClient) {}

  login() {
    return this.http.get(apis.login);
  }

  getUserInfo(access_token: string) {
    return this.http.get(apis.userInfo, { params: { access_token } });
  }

  logout(access_token: string) {
    return this.http.get(apis.logout, { params: { access_token } });
  }

  redirectUrl(shortUrl: string) {
    return this.http.get(apis.link + shortUrl);
  }
}
