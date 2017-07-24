package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;

public interface TrabalhoRepository extends
    PagingAndSortingRepository<Trabalho, Long> {

    List<Trabalho> findByTitulo (String titulo);

}

// OK
