package com.perso.bibliothequeback.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reader")
@Getter
@Setter
@NoArgsConstructor
public class Reader {
    @Id
    private String name;

    @OneToMany(mappedBy = "id.reader", fetch = FetchType.LAZY)
    private List<BookReaderData> library;
}
