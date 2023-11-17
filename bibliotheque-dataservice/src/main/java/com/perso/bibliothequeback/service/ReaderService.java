package com.perso.bibliothequeback.service;

import com.perso.bibliothequeback.domain.model.Book;
import com.perso.bibliothequeback.domain.model.BookReaderData;
import com.perso.bibliothequeback.domain.model.Reader;
import com.perso.bibliothequeback.domain.repository.BookRepository;
import com.perso.bibliothequeback.domain.repository.LibraryRepository;
import com.perso.bibliothequeback.domain.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<BookReaderData> getBooksByReader(Reader r) {
        return r.getLibrary();
    }

    public List<String> getReadersList() {
        return readerRepository.findAll()
                .stream()
                .map(Reader::getName)
                .toList();
    }

    public void postBookToUserLibrary(Boolean areAllVolumesRead, Book book, Boolean isRead, Integer rating, Reader reader, Date readingDate) {
        if (book.getId() == null) {
            book.setId(Integer.toString(Objects.hash(book.getTitle(), book.getPageCount(), book.getDescription())));
            book.setIsCreatedByReader(true);
        }
        bookRepository.save(book);
        libraryRepository.save(new BookReaderData(areAllVolumesRead, book, isRead, rating, reader, readingDate));
    }

    public Page<BookReaderData> getReaderBooksRange(Reader r, Integer page, Integer size) {
        return libraryRepository.findAllByIdReaderName(r.getName(), PageRequest.of(page, size, Sort.by("IdBookAuthorLastName").ascending().and(Sort.by("IdBookTitle").ascending())));
    }

    public Page<BookReaderData> getReaderBooksRangeByAuthor(Reader r, Integer page, Integer size, String authorLastName, Boolean isRead) {
        return libraryRepository.findAllByIdReaderNameAndIdBookAuthorLastNameContainsAndIsRead(r.getName(), PageRequest.of(page, size, Sort.by("IdBookAuthorLastName").ascending().and(Sort.by("IdBookTitle").ascending())), authorLastName, isRead);
    }
}
