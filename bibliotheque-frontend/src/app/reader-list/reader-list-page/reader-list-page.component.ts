import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { ReaderService } from 'src/app/backend/reader.service';
import { ReaderBookData } from 'src/app/reader-list/models/reader-book-data';
import { ReaderListComponent } from 'src/app/reader-list/reader-list/reader-list.component';

@Component({
  templateUrl: './reader-list-page.component.html',
  styleUrls: ['./reader-list-page.component.scss']
})
export class ReaderListPageComponent implements OnInit {

  public searchBookSubject: Subject<ReaderBookData> = new Subject<ReaderBookData>();
  public readerBooks: ReaderBookData[];
  public reader: string = '';
  @ViewChild(ReaderListComponent) private readerListComponent: ReaderListComponent;

  constructor(
    private activatedRoute: ActivatedRoute,
    private readerService: ReaderService,
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async params => {
      this.reader = params['user'];
      this.searchBookSubject.next(new ReaderBookData());
    });
  }

  public async addBookToLibrary(book: ReaderBookData): Promise<void> {
    await this.readerService.postBookToReadersList(book, this.reader);
    this.readerListComponent.getBooks();
    this.searchBookSubject.next(new ReaderBookData());
  }


  public bookSelected(event: ReaderBookData) {
    this.searchBookSubject.next(event);
  }

}
