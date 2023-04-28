import { ReaderBookData } from "src/app/reader-list/models/reader-book-data";
import { GoogleBookData } from "src/app/reader-list/models/google-book-data";

export class BookListItem {
    googleData: GoogleBookData;
    readerData: ReaderBookData;

    constructor(googleBook: GoogleBookData, readerBookData: ReaderBookData) {
        this.googleData = googleBook;
        this.readerData = readerBookData;
    }
}
