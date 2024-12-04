import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apis } from '../../../app.apis';
import { Link, LinkPayload } from './link.models';
import { HttpService } from '../../../libary/http.service';
import { Store } from '@ngrx/store';

@Injectable({
  providedIn: 'root',
})
export class LinkService {
  constructor(private http: HttpService) {}

  getLinks(token?: string): Observable<Link[]> {
    console.log('Get Link API->' + apis.link + ' : Token -> ' + token);
    return this.http.get<Link[]>(apis.link, token);
  }

  addLink(payload: LinkPayload, token: string): Observable<Link> {
    return this.http.post<Link>(apis.link, payload, token);
  }

  updateLink(payload: LinkPayload): Observable<Link> {
    return this.http.put<Link>(`${apis.link}/${payload.id}`, { payload });
  }

  deleteLink(id: number): Observable<void> {
    return this.http.delete<void>(`${apis.link}/${id}`);
  }
}
