import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  constructor(private http: HttpClient) {}

  searchBooks(searchBooks: any): Observable<string[]> {
    const apiName = searchBooks.filtre === 'default' ? 'default' : 'closeness';
    const params: HttpParams = new HttpParams().set('word', searchBooks.word);
    return this.http.get<string[]>(SERVER_API_URL + '/api/books/' + apiName, { params });
  }

  searchSuggestion(filename: string): Observable<string[]> {
    const params: HttpParams = new HttpParams().set('filename', filename);
    return this.http.get<string[]>(SERVER_API_URL + '/api/books/suggestion', { params });
  }

  getDataOnBook(fileNum: string): Observable<any> {
    console.log('http://gutendex.com/books/' + fileNum);
    return this.http.get('http://gutendex.com/books/' + fileNum, {});
  }
}
