package com.perso.bibliothequeback.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ReaderOpinionId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "reader_name")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
