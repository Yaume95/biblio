import { Book } from "src/app/reader-list/models/book";

export class ReaderBookData {
    allVolumesRead: boolean;
    book: Book;
    isRead: boolean = false;
    rating: number;
    readingDate: Date;

    constructor(book?: Book, isRead?: boolean, rating?: number, readingDate?: Date, allVolumesRead?: boolean);
    constructor(book: Book, isRead: boolean, rating: number, readingDate: Date, allVolumesRead: boolean) {
        this.allVolumesRead = allVolumesRead;
        this.book = book || new Book();
        this.isRead = isRead;
        this.rating = rating;
        if (readingDate) {
            this.readingDate = new Date(readingDate);
        }

    }

    public get isReadLabel(): string {
        return !!this.isRead ? 'Lu' + (!!this.readingDate ? ` le ${this.readingDate.toLocaleDateString('fr-FR')}` : '') : 'Non lu';
    }

    public get areAllVolumesReadLabel(): string {
        return `Saga ${!!this.allVolumesRead ? 'terminée' : 'non terminée'}`;
    }
}
