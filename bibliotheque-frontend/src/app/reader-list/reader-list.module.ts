import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDateFnsModule } from '@angular/material-date-fns-adapter';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { fr } from 'date-fns/locale';
import { MatButtonModule } from '@angular/material/button';
import { BookToAddComponent } from 'src/app/reader-list/book-to-add/book-to-add.component';
import { GoogleBooksSearchComponent } from 'src/app/reader-list/google-books-autocompletion/google-books-autocompletion.component';
import { ReaderListPageComponent } from 'src/app/reader-list/reader-list-page/reader-list-page.component';
import { StarRaterComponent } from 'src/app/reader-list/star-rater/star-rater.component';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule  } from '@angular/material/toolbar';
import { HeaderComponent } from 'src/app/reader-list/header/header.component';
import { ReaderListComponent } from './reader-list/reader-list.component';
@NgModule({
  declarations: [
    HeaderComponent,
    BookToAddComponent,
    GoogleBooksSearchComponent,
    ReaderListPageComponent,
    StarRaterComponent,
    ReaderListComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatDateFnsModule,
    MatDatepickerModule,
    MatDividerModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
  ],
  providers: [
    {
      provide: MAT_DATE_LOCALE,
      useValue: fr,
    },
  ]
})
export class ReaderListModule { }
