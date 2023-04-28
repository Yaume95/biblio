export class GoogleBookData {
    authors: string;
    description: string;
    id: string;
    pageCount: number;
    pictureUrl?: string;
    title: string;

    public hasAuthors(): boolean {
        return !!this.authors;
    }
}
