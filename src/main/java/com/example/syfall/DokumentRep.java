package com.example.syfall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DokumentRep extends JpaRepository<Dokumente, Long> {

}
