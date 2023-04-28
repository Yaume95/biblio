import { Component, Input, Output, EventEmitter, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Subject } from 'rxjs';
import { GoogleBookData } from 'src/app/reader-list/models/google-book-data';

export class Toto {
  comment: string;
  readingDate: Date;
  rating: number;
  isRead: boolean;
  bookId: string;
  pictureUrl: string;

  constructor(bookId: string, comment: string, readingDate: Date, rating: number, isRead: boolean) {
    this.bookId = bookId;
    this.comment = comment;
    this.readingDate = readingDate;
    this.rating = rating;
    this.isRead = isRead;
  }
}

@Component({
  selector: 'app-book-to-add',
  templateUrl: './book-to-add.component.html',
  styleUrls: ['./book-to-add.component.scss'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class BookToAddComponent implements OnInit {
  private readonly DEFAULT_COVER_URL = 'data:image/png;base64,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';
  
  @Input() searchBookSubject: Subject<GoogleBookData>;
  @Output() onReaderAddBook: EventEmitter<Toto> = new EventEmitter<Toto>();

  public commentInputText: string;
  public readingDate: Date;
  public rating: number = 0;
  public isRead: boolean = false;
  public googleBook: GoogleBookData = new GoogleBookData();

  ngOnInit(): void {
    this.searchBookSubject.subscribe((book: GoogleBookData) => {
      this.googleBook = book;
      this.commentInputText = '';
      this.readingDate = null;
      this.rating = 0;
      this.isRead = false;
    });
  }

  public addReaderBook(): void {
    this.onReaderAddBook.emit(new Toto(this.googleBook.id, this.commentInputText, this.readingDate, this.rating, this.isRead));
  }

  clear() {
    this.googleBook = new GoogleBookData();
  }

  public getCover(book: GoogleBookData): string {
    return book?.pictureUrl || this.DEFAULT_COVER_URL;
  }

}
