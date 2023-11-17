package com.perso.bibliothequeback.domain.model.Request;

import com.perso.bibliothequeback.domain.model.BookReaderData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetReaderBooksResponse {
    private Long total;
    private List<BookReaderData> books;
}
