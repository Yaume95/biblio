import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom, firstValueFrom } from 'rxjs';
import { Book } from 'src/app/reader-list/models/book';
import { GetReaderBooksResponse } from 'src/app/reader-list/models/get-reader-books-response';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ReaderService {

  constructor(private httpClient: HttpClient) { }


  public postBookToReadersList(readerBook: ReaderBookData, reader: string): Promise<void> {
    return lastValueFrom(this.httpClient.post<void>(`${environment.bibliothequeDataserviceUrl}/readers/${reader}/books`, readerBook));
  }

  public async getReaderBooks(reader: string, page: number, size: number, authorLastName?: string, isRead?: boolean) {
    let url: string = `${environment.bibliothequeDataserviceUrl}/readers/${reader}/books?page=${page}&size=${size}`;
    if(authorLastName != null) {
      url += `&author=${authorLastName}`;
    }
    if(isRead != null) {
      url += `&isRead=${isRead}`;
    }
    const res: GetReaderBooksResponse = await firstValueFrom(this.httpClient.get<GetReaderBooksResponse>(url));
    this.mapBooksFromReaderBooksResponse(res);
    return res;
  }

  private mapBooksFromReaderBooksResponse(response: GetReaderBooksResponse): void {
    response.books = response.books.map((b: ReaderBookData) => new ReaderBookData(Object.assign(new Book(), b.book), b.isRead, b.rating, b.readingDate, b.allVolumesRead));
  }

}
