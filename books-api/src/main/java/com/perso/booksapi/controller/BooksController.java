package com.perso.booksapi.controller;

import com.perso.booksapi.controller.Response.BookResponse;
import com.perso.booksapi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/search")
    public List<BookResponse> search(@RequestParam("text") String text) {
        var res = booksService.search(text);
        return res.stream().filter(b -> b.getVolumeInfo().getIndustryIdentifiers() != null).map(BookResponse::new).toList();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") String id) {
        var res = booksService.getBookById(id);
        return new BookResponse(res);
    }


}
