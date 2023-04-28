import { Component, Input } from '@angular/core';
import { Subject } from 'rxjs';
import { GoogleBookData } from 'src/app/reader-list/models/google-book-data';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  @Input() searchBookSubject: Subject<GoogleBookData>;

  public load(book: GoogleBookData): void {
    this.searchBookSubject.next(book);
  }

}
