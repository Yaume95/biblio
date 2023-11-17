package com.perso.bibliothequeback.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Book {
    @Id
    @Setter
    private String id;

    private String authorFirstName;

    private String authorLastName;

    private String category;

    private String description;

    @Setter
    private Boolean isCreatedByReader;

    private Integer pageCount;

    private String picture;

    private String title;

    private Integer volume;

    public Book(String id) {
        this.id = id;
    }
}
