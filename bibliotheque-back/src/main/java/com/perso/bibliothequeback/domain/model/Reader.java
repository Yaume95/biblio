package com.perso.bibliothequeback.domain.model;

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

    @OneToMany(mappedBy = "book.reader", fetch = FetchType.EAGER)
    private List<Opinion> opinions;
}
