import { ReaderBookData } from "src/app/reader-list/models/reader-book-data";
export interface GetReaderBooksResponse {
    total: number;
    books: ReaderBookData[]
}
