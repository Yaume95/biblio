package com.perso.bibliothequeback.controller;

import com.perso.bibliothequeback.domain.model.Reader;
import com.perso.bibliothequeback.domain.model.Request.GetReaderBooksResponse;
import com.perso.bibliothequeback.domain.model.Request.PostBookRequest;
import com.perso.bibliothequeback.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("readers")
@Validated
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping(value="",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getListOfReaders() {
        return readerService.getReadersList();
    }

    @GetMapping(value = "/{reader}/books", produces = MediaType.APPLICATION_JSON_VALUE, params = { "page", "size" })
    public GetReaderBooksResponse getBooksByReader(@PathVariable("reader") Reader reader, @RequestParam("page") Integer page, @RequestParam("size") Integer size ) {
        var res = readerService.getReaderBooksRange(reader, page, size);
        return new GetReaderBooksResponse(res.getTotalElements(), res.getContent());
    }

    @PostMapping(value ="{reader}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public void postBookToUserLibrary(@PathVariable("reader") Reader reader, @RequestBody PostBookRequest request) {
        readerService.postBookToUserLibrary(request.getAllVolumesRead(), request.getBook(), request.getIsRead(), request.getRating(), reader, request.getReadingDate());
    }

    @GetMapping(value = "/{reader}/books", produces = MediaType.APPLICATION_JSON_VALUE, params = { "page", "size", "author", "isRead" })
    public GetReaderBooksResponse getBooksByReader(@PathVariable Reader reader, @RequestParam Integer page, @RequestParam Integer size, @RequestParam String author, @RequestParam(required = false) Boolean isRead) {
        var res = readerService.getReaderBooksRangeByAuthor(reader, page, size, author, isRead);
        return new GetReaderBooksResponse(res.getTotalElements(), res.getContent());
    }
}