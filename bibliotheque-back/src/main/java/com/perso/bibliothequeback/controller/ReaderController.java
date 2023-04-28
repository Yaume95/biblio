package com.perso.bibliothequeback.controller;

import com.perso.bibliothequeback.domain.model.Opinion;
import com.perso.bibliothequeback.domain.model.Reader;
import com.perso.bibliothequeback.domain.model.Request.AddBookRequest;
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

    @GetMapping(value = "/{reader}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Opinion> getBooksByReader(@PathVariable("reader") Reader reader) {
        return reader.getOpinions();
    }

    @PostMapping(value ="{reader}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addBookToUserLibrary(@PathVariable("reader") Reader reader, @RequestBody AddBookRequest request) {
        readerService.addBookToUserLibrary(
                request.getComment(),
                request.getDescription(),
                request.getId(),
                request.getIsRead(),
                request.getRating(),
                reader,
                request.getReadingDate()
        );
    }

}
