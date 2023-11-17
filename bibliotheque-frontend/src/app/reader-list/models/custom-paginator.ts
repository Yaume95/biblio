import { MatPaginatorIntl } from "@angular/material/paginator";

export function CustomPaginator() {
    const customPaginatorIntl = new MatPaginatorIntl();
    customPaginatorIntl.firstPageLabel = 'Première page';
    customPaginatorIntl.lastPageLabel = 'Dernière page';
    customPaginatorIntl.nextPageLabel = 'Page suivante';
    customPaginatorIntl.previousPageLabel = 'Page précédente';
    customPaginatorIntl.getRangeLabel = (page: number, pageSize: number, length: number): string => `${page + 1} sur ${Math.ceil(length / pageSize)}`;
    customPaginatorIntl.itemsPerPageLabel = 'Livres par page';
    return customPaginatorIntl;
}