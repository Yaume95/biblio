package com.perso.bibliothequeback.domain.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "book_reader_data")
@NoArgsConstructor
public class BookReaderData {

    private Boolean allVolumesRead;

    @EmbeddedId
    @JsonProperty("book")
    private ReaderDataId id;

    private Boolean isRead;

    private Integer rating;

    private Date readingDate;

    @JsonGetter
    public Book getBook() {
        return id.getBook();
    }

    public BookReaderData(Boolean allVolumesRead, Book book, Boolean isRead, Integer rating, Reader reader, Date readingDate) {
        this.allVolumesRead = allVolumesRead;
        this.id = new ReaderDataId();
        this.id.setBook(book);
        this.id.setReader(reader);
        this.isRead = isRead;
        this.rating = rating;
        this.readingDate = readingDate;
    }
}
