package com.perso.booksapi.domain.model.google;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@Getter
public class VolumeInfo {
    private String title = null;
    private List<String> authors = new ArrayList<>();
    private String description = null;
    private ImageLinks imageLinks = new ImageLinks();
    private Number pageCount = null;
    private List<IndustryIdentifier> industryIdentifiers;

    public String getISBN() {
        return industryIdentifiers.stream()
                .filter(IndustryIdentifier::isISBN13)
                .findFirst()
                .orElse(industryIdentifiers.stream().filter(IndustryIdentifier::isISBN10).findFirst()
                        .orElse(industryIdentifiers.get(0)))
                .getIdentifier();
    }


}

