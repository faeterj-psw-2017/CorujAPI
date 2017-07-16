package org.faeterj.apicoruja.faeterj.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.faeterj.apicoruja.coruja.model.entity.Trabalho;

public interface TrabalhoRepository extends
        PagingAndSortingRepository<Trabalho, Long> {

    List<Trabalho> findById     (@Param("trabalho_id") long   id);
    List<Trabalho> findByTitulo (@Param("titulo")      String titulo);

}

// OK
