import { Component, EventEmitter, Input, OnInit, Output, OnChanges, SimpleChanges } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Subject } from 'rxjs';
import { Book } from 'src/app/reader-list/models/book';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';

@Component({
  selector: 'app-book-to-add',
  templateUrl: './book-to-add.component.html',
  styleUrls: ['./book-to-add.component.scss']
})
export class BookToAddComponent implements OnInit {

  private static readonly SNACK_BAR_SETTINGS: MatSnackBarConfig = { duration: 2000, verticalPosition: 'bottom', horizontalPosition: 'center' };

  @Input() searchBookSubject: Subject<ReaderBookData>;
  @Output() onReaderAddBook: EventEmitter<ReaderBookData> = new EventEmitter<ReaderBookData>();

  public categories: String[] = [null,
    'Adolescent',
    'Dark Romance',
    'Documentaire',
    'Fantastique',
    'Horreur',
    'Policier',
    'Post Apocalyptique',
    'Romance',
    'Science-Fiction',
  ];
  public readerBook: ReaderBookData = new ReaderBookData(new Book());

  constructor(private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.searchBookSubject.subscribe((readerBook: ReaderBookData) => {
      this.readerBook = Object.assign(new ReaderBookData(), readerBook);
      this.readerBook.book = Object.assign(new Book(), readerBook.book);
    });
  }

  public addReaderBook(): void {
    try {
      this.onReaderAddBook.emit(this.readerBook);
      this.snackBar.open('Modifications enregistrées', 'x', BookToAddComponent.SNACK_BAR_SETTINGS);
    } catch (e) {
      this.snackBar.open('Une erreur est survenue', 'x', BookToAddComponent.SNACK_BAR_SETTINGS);
    }
  }

  clear() {
    this.readerBook = new ReaderBookData(new Book());
  }
}
