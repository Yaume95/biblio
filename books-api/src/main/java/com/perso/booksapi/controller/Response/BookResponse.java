package com.perso.booksapi.controller.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.perso.booksapi.domain.model.google.GoogleBook;
import lombok.Getter;

import java.util.Arrays;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    private final String authorFirstName;
    private final String authorLastName;
    private final String category;
    private final String description;
    private final String id;
    private final Number pageCount;
    private final String picture;
    private final String title;
    private final Integer volume;

    public BookResponse(GoogleBook googleBook) {
        var lastName = "";
        var firstName = "";
        if (googleBook.getVolumeInfo().getAuthors().size() > 0) {
            var author = googleBook.getVolumeInfo().getAuthors().get(0).split(" ");
            lastName = author[author.length - 1];
            firstName = String.join(" ", Arrays.copyOfRange(author, 0, author.length - 1));
        }
        authorFirstName = firstName;
        authorLastName = lastName;
        category = null;
        description = googleBook.getVolumeInfo().getDescription();
        id = googleBook.getVolumeInfo().getISBN();
        pageCount = googleBook.getVolumeInfo().getPageCount();
        picture = googleBook.getVolumeInfo().getImageLinks().getSmallThumbnail();
        title = googleBook.getVolumeInfo().getTitle();
        volume = null;
    }

}
