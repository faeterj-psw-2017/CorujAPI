package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

/**
 * Created by William Lemos on 23/07/17.
 */


public interface TurmaRepository extends
    PagingAndSortingRepository<Turma, Long> {

	List<Turma> findById (Long id);
    List<Turma> findByCodigo (String codigo);
    List<Turma> findBySala   (String sala);
    List<Turma> findByTurno  (char   turno);
    List<Turma> findAll ();
}

// OK
