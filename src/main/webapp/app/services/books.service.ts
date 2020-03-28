import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  constructor(private http: HttpClient) {}

  searchBooks(searchBooks: any, numPage: number, pageSize: number): Observable<any> {
    const apiName = searchBooks.filtre === 'default' ? 'default' : 'closeness';
    const params: HttpParams = new HttpParams()
      .set('word', searchBooks.word)
      .set('page', String(numPage))
      .set('pageSize', String(pageSize));
    return this.http.get<string[]>(SERVER_API_URL + '/api/books/' + apiName, { params });
  }

  searchSuggestion(filename: string): Observable<string[]> {
    const params: HttpParams = new HttpParams().set('filename', filename);
    return this.http.get<string[]>(SERVER_API_URL + '/api/books/suggestion', { params });
  }

  getDataOnBook(fileNum: string): Observable<any> {
    return this.http.get('http://gutendex.com/books/' + fileNum, {});
  }
}
