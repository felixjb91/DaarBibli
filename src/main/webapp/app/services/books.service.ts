import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  constructor(private http: HttpClient) {}

  searchBooksName(value: any): Observable<string[]> {
    const params: HttpParams = new HttpParams().set('word', value.word);
    console.log('begin');
    return this.http.get<string[]>(SERVER_API_URL + '/api/books/fileName', { params });
  }
}
