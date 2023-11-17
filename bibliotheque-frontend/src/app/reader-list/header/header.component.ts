import { Component, Input } from '@angular/core';
import { Subject } from 'rxjs';
import { Book } from 'src/app/reader-list/models/book';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  @Input() searchBookSubject: Subject<ReaderBookData>;

  public load(book: Book): void {
    this.searchBookSubject.next(new ReaderBookData(book, false, 0, null));
  }

}
