package com.perso.bibliothequeback.service;

import com.perso.bibliothequeback.domain.model.Book;
import com.perso.bibliothequeback.domain.model.Opinion;
import com.perso.bibliothequeback.domain.model.Reader;
import com.perso.bibliothequeback.domain.repository.BookRepository;
import com.perso.bibliothequeback.domain.repository.OpinionRepository;
import com.perso.bibliothequeback.domain.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Opinion> getBooksByReader(Reader r) {
        return r.getOpinions();
    }

    public List<String> getReadersList() {
        return readerRepository.findAll()
                .stream()
                .map(Reader::getName)
                .toList();
    }

    public void addBookToUserLibrary(
            String comment,
            String description,
            String bookId,
            Boolean isRead,
            Integer rating,
            Reader reader,
            Date readingDate
    ) {
        var book = new Book(bookId);
        bookRepository.save(book);
        opinionRepository.save(new Opinion(comment, description, rating, isRead, reader, book));
    }
}
