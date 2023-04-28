package com.perso.bibliothequeback.domain.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "reader_opinion")
@NoArgsConstructor
public class Opinion {

    @EmbeddedId
    private ReaderOpinionId book;

    private String comment;

    private String summary;

    private Integer rating;

    private Boolean isRead;

    @JsonGetter
    public Book getBook() {
        return book.getBook();
    }

    public Opinion(String comment, String summary, Integer rating, Boolean isRead, Reader reader, Book book) {
        this.comment = comment;
        this.summary = summary;
        this.rating = rating;
        this.isRead = isRead;
        this.book = new ReaderOpinionId();
        this.book.setReader(reader);
        this.book.setBook(book);
    }
}
