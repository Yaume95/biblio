package com.perso.booksapi.domain.model.google;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class GoogleBookSearchResult {
    private List<GoogleBook> items;
    private Integer totalItems;
}
