package com.perso.bibliothequeback.domain.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perso.bibliothequeback.domain.model.Reader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AddBookRequest {
    @JsonProperty
    private String id;

    @JsonProperty
    private String comment;

    @JsonProperty
    private String description;

    @JsonProperty
    private Integer rating;

    @JsonProperty
    private Date readingDate;

    @JsonProperty
    private Boolean isRead;

    @JsonProperty
    private Reader reader;
}
