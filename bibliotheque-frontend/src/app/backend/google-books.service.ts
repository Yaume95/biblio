import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mutex } from 'async-mutex';
import { Observable, Subscription, lastValueFrom, of } from 'rxjs';
import { Book } from 'src/app/reader-list/models/book';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GoogleBooksService {

  private booksSearchSubscription: Subscription;
  constructor(private httpClient: HttpClient) { }

  private searchBooksWithApi(searchText: string): Observable<Book[]> {
    if (searchText.length === 0) {
      return of([]);
    }
    this.booksSearchSubscription?.unsubscribe();
    return this.httpClient.get<Book[]>(`${environment.booksWebserviceUrl}/books/search?text=${encodeURI(searchText)}`);

  }

  public booksAutocompletion(searchText: string): Promise<Book[]> {
    return new Promise(resolve => {
      this.booksSearchSubscription = this.searchBooksWithApi(searchText)
        .subscribe((books: Book[]) =>
          resolve(books.map(b => Object.assign(new Book(), b)))
        );
    });
  }

  public getBook(id: string) {
    return lastValueFrom(this.httpClient.get<Book[]>(`${environment.booksWebserviceUrl}/books/${encodeURI(id)}`));

  }
}
