package com.perso.bibliothequeback.domain.repository;

import com.perso.bibliothequeback.domain.model.Opinion;
import com.perso.bibliothequeback.domain.model.ReaderOpinionId;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, ReaderOpinionId>{
}
