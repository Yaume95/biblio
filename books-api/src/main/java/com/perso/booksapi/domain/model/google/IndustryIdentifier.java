package com.perso.booksapi.domain.model.google;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IndustryIdentifier {
    private String type;
    private String identifier;

    public boolean isISBN13() {
        return this.type.equals("ISBN_13");
    }

    public boolean isISBN10() {
        return this.type.equals("ISBN_10");
    }
}
