import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatDateFnsModule } from '@angular/material-date-fns-adapter';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { fr } from 'date-fns/locale';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { BookToAddComponent } from 'src/app/reader-list/book-to-add/book-to-add.component';
import { GoogleBooksSearchComponent } from 'src/app/reader-list/google-books-autocompletion/google-books-autocompletion.component';
import { HeaderComponent } from 'src/app/reader-list/header/header.component';
import { ReaderListPageComponent } from 'src/app/reader-list/reader-list-page/reader-list-page.component';
import { StarRaterComponent } from 'src/app/reader-list/star-rater/star-rater.component';
import { ReaderListComponent } from './reader-list/reader-list.component';
import { MatSelectModule } from '@angular/material/select';

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
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatDateFnsModule,
    MatDatepickerModule,
    MatDividerModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatPaginatorModule,
    MatSelectModule,
    MatSnackBarModule,
    MatToolbarModule,
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: fr, },
  ]
})
export class ReaderListModule { }
