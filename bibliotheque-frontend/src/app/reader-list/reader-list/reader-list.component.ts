import { Component, Input } from '@angular/core';
import { BookListItem } from 'src/app/reader-list/models/book-list-item';

@Component({
  selector: 'app-reader-list',
  templateUrl: './reader-list.component.html',
  styleUrls: ['./reader-list.component.scss']
})
export class ReaderListComponent {

  @Input() readerBooks: BookListItem[];

}
