package com.perso.googlebooksapi.service;

import com.perso.googlebooksapi.domain.model.GoogleBook;
import com.perso.googlebooksapi.domain.model.GoogleBookSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class GoogleBooksService {
    @Autowired
    private WebClient webClient;

    public List<GoogleBook> search(String searchText) {
        GoogleBookSearchResult res = webClient.get()
                .uri("/volumes?q=" + searchText)
                .retrieve()
                .bodyToMono(GoogleBookSearchResult.class)
                .block();
        if (res.getTotalItems() > 0) {
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
