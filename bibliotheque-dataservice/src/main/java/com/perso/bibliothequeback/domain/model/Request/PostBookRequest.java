package com.perso.bibliothequeback.domain.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perso.bibliothequeback.domain.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostBookRequest {

    @JsonProperty
    private Boolean allVolumesRead;

    @JsonProperty
    private Book book;

    @JsonProperty
    private String comment;

    @JsonProperty
    private Integer rating;

    @JsonProperty
    private Date readingDate;

    @JsonProperty
    private Boolean isRead;
}
