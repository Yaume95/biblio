import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';
import { GoogleBookData } from 'src/app/reader-list/models/google-book-data';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ReaderService {

  constructor(private httpClient: HttpClient) { }

  public getReaderBooks(reader: String): Promise<ReaderBookData[]> {
    return lastValueFrom(this.httpClient.get<any[]>(`${environment.bibliothequeBackUrl}/readers/${reader}/books`));
  }

  public addBookToReadersList( id: string, description: string, comment: string, rating: number, isRead: boolean, reader: string, readingdDate: Date): Promise<void> {
    return lastValueFrom(this.httpClient.post<void>(`${environment.bibliothequeBackUrl}/readers/${reader}/books`, {
      comment: comment,
      description: description,
      id: id,
      isRead: isRead,
      rating: rating,
      readingdDate: readingdDate
    }));
  }

}
