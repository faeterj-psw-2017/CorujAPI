package org.faeterj.apicoruja.faeterj.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

public interface TurmaRepository extends
    PagingAndSortingRepository<Turma, Long> {

    List<Turma> findByCodigo (String codigo);
    List<Turma> findBySala   (String sala);
    List<Turma> findByTurno  (char   turno);

}

// OK
