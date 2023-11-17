package com.perso.bibliothequeback.domain.repository;

import com.perso.bibliothequeback.domain.model.BookReaderData;
import com.perso.bibliothequeback.domain.model.ReaderDataId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<BookReaderData, ReaderDataId>{
    Page<BookReaderData> findAllByIdReaderName(String readerI, PageRequest pageable);

    Page<BookReaderData> findAllByIdReaderNameAndIdBookAuthorLastNameContainsAndIsRead(String reader, PageRequest pageable, String AuthorLastName, Boolean isRead);
}
