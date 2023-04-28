package com.perso.bibliothequeback.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Book {
    @Id
    private String id;

    private String summary;

    private Byte[] picture;

    public Book(String id) {
        this.id = id;
    }
}
