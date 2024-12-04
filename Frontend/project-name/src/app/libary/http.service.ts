import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  constructor(private http: HttpClient) {}

  private authHeader(token?: string) {
    let httpHeaders = new HttpHeaders();
    if (token) {
      httpHeaders = httpHeaders.set('Authorization', `Bearer ${token}`);
    }
    return {
      headers: httpHeaders,
    };
  }

  public get<T>(url: string, token?: string): Observable<T> {
    return this.http.get<T>(url, this.authHeader(token));
  }

  public post<T>(url: string, body: any, token?: string): Observable<T> {
    return this.http.post<T>(url, body, this.authHeader(token));
  }

  public put<T>(
    url: string,
    body: any,
    headers?: HttpHeaders,
    params?: HttpParams,
    token?: string
  ): Observable<T> {
    return this.http.put<T>(url, body);
  }

  public delete<T>(
    url: string,
    headers?: HttpHeaders,
    params?: HttpParams,
    token?: string
  ): Observable<T> {
    return this.http.delete<T>(url);
  }
}
