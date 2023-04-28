import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mutex } from 'async-mutex';
import { Observable, Subscription, lastValueFrom, of } from 'rxjs';
import { GoogleBookData } from 'src/app/reader-list/models/google-book-data';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GoogleBooksService {

  private booksSearchSubscription: Subscription;
  constructor(private httpClient: HttpClient) { }

  private searchBooksWithApi(searchText: string): Observable<GoogleBookData[]> {
    if(searchText.length === 0) {
      return of([]);
    }
    this.booksSearchSubscription?.unsubscribe();
   return this.httpClient.get<GoogleBookData[]>(`${environment.googleBooksBackUrl}/books/search?text=${encodeURI(searchText)}`);

  }

  public booksAutocompletion(searchText: string): Promise<GoogleBookData[]> {
    return new Promise(resolve => {
      this.booksSearchSubscription = this.searchBooksWithApi(searchText).subscribe((books: GoogleBookData[]) => resolve(books));
    })
  }

  public getBook(id: string) {
   return lastValueFrom(this.httpClient.get<GoogleBookData[]>(`${environment.googleBooksBackUrl}/books/${encodeURI(id)}`));

  }
}
