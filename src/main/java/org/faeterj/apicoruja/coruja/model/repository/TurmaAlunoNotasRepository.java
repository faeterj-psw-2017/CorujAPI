package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.TurmaAlunoNotas;

public interface TurmaAlunoNotasRepository extends
    PagingAndSortingRepository<TurmaAlunoNotas, Long> {

}

// OK
