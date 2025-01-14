import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apis } from '../../../app.apis';
import { HttpService } from '../../../libary/http.service';
import { Store } from '@ngrx/store';
import { CustomLink, CustomLinkPayload } from './custom-link.models';

@Injectable({
  providedIn: 'root',
})
export class CustomLinkService {
  constructor(private http: HttpService) {}

  getLinks(token?: string): Observable<CustomLink[]> {
    console.log('Get Link API->' + apis.link + ' : Token -> ' + token);
    return this.http.get<CustomLink[]>(apis.customLink, token);
  }

  addLink(payload: CustomLinkPayload, token: string): Observable<CustomLink> {
    return this.http.post<CustomLink>(apis.customLink, payload, token);
  }

  updateLink(
    payload: CustomLinkPayload,
    token: string
  ): Observable<CustomLink> {
    return this.http.put<CustomLink>(apis.customLink, payload, token);
  }

  deleteLink(id: number, token): Observable<boolean> {
    return this.http.post<boolean>(
      `${apis.customLink}/delete/${id}`,
      {},
      token
    );
  }
}
