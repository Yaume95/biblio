package com.perso.bibliothequeback.domain.repository;

import com.perso.bibliothequeback.domain.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReaderRepository extends JpaRepository<Reader, String> {
}
