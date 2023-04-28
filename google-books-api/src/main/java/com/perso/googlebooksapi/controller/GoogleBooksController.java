package com.perso.googlebooksapi.controller;

import com.perso.googlebooksapi.domain.model.GoogleBook;
import com.perso.googlebooksapi.domain.model.Response.GoogleBookResponse;
import com.perso.googlebooksapi.service.GoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class GoogleBooksController {

    @Autowired
    private GoogleBooksService googleBooksService;

    @GetMapping("/search")
    public List<GoogleBookResponse> search(@RequestParam("text") String text) {
        var res = googleBooksService.search(text);
        return res.stream().map(GoogleBookResponse::new).toList();
    }

    @GetMapping("/{id}")
    public GoogleBookResponse getBookById(@PathVariable("id") String id) {
        var res = googleBooksService.getBookById(id);
        return new GoogleBookResponse(res);
    }


}
