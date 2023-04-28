import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject, forkJoin } from 'rxjs';
import { Toto } from 'src/app/reader-list/book-to-add/book-to-add.component';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';
import { BookListItem } from 'src/app/reader-list/models/book-list-item';
import { GoogleBookData } from 'src/app/reader-list/models/google-book-data';
import { GoogleBooksService } from 'src/app/reader-list/services/google-books.service';
import { ReaderService } from 'src/app/reader-list/services/reader.service';

@Component({
  templateUrl: './reader-list-page.component.html',
  styleUrls: ['./reader-list-page.component.scss']
})
export class ReaderListPageComponent implements OnInit {

  public searchedBookSubject: Subject<GoogleBookData> = new Subject<GoogleBookData>();
  private reader: string = '';
  private readersShelf: ReaderBookData[];
  public readerBooks: any[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private googleBooksService: GoogleBooksService,
    private readerService: ReaderService,
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async params => {
      this.reader = params['user'];
      this.setReaderBooks();
      this.searchedBookSubject.next(null);
    });
  }

  public async addBookToLibrary(book: Toto): Promise<void> {
    await this.readerService.addBookToReadersList(
      book.bookId,
      null,
      book.comment,
      book.rating,
      book.isRead,
      this.reader,
      book.readingDate
    );
    this.setReaderBooks();
    this.searchedBookSubject.next(null);
  }

  private async setReaderBooks() {
    this.readersShelf = await this.readerService.getReaderBooks(this.reader);
    const fork = this.readersShelf.map((book: any) => this.googleBooksService.getBook(book.book.id));
    forkJoin(fork).subscribe((googleBooks: any) => {
      this.readerBooks = googleBooks.map((gbook: any) => {
        const bookReaderData = this.readersShelf.find((b: any) => gbook.id === b.book.id);
        return new BookListItem(gbook, bookReaderData);
      });
    });
  }

}
