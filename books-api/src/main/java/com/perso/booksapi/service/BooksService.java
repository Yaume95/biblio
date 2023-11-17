package com.perso.booksapi.service;

import com.perso.booksapi.domain.model.google.GoogleBook;
import com.perso.booksapi.domain.model.google.GoogleBookSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private WebClient webClient;

    public List<GoogleBook> search(String searchText) {
        GoogleBookSearchResult res = webClient.get()
                .uri("/volumes?q=" + searchText)
                .retrieve()
                .bodyToMono(GoogleBookSearchResult.class)
                .block();
        if (res != null && res.getTotalItems() > 0) {
            return res.getItems();
        }
        return List.of();
    }


    public GoogleBook getBookById(String id) {
        return webClient.get()
                .uri("/volumes/" + id)
                .retrieve()
                .bodyToMono(GoogleBook.class)
                .block();
    }
}
