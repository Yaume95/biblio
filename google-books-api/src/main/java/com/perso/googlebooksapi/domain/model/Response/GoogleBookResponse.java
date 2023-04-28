package com.perso.googlebooksapi.domain.model.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.perso.googlebooksapi.domain.model.GoogleBook;
import lombok.Getter;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoogleBookResponse {
    private final String authors;
    private final String description;
    private final String id;
    private final Number pageCount;
    private final String pictureUrl;
    private final String title;

    public GoogleBookResponse(GoogleBook googleBook) {
        authors = String.join("", googleBook.getVolumeInfo().getAuthors());
        title = googleBook.getVolumeInfo().getTitle();
        description = googleBook.getVolumeInfo().getDescription();
        id = googleBook.getId();
        pageCount = googleBook.getVolumeInfo().getPageCount();
        pictureUrl = googleBook.getVolumeInfo().getImageLinks().getSmallThumbnail();
    }

}
