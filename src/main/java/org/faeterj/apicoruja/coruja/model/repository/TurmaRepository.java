package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

/**
 * Created by William Lemos on 23/07/17.
 */
@Repository
@RepositoryRestResource(path="/turma-page")
public interface TurmaRepository extends
    PagingAndSortingRepository<Turma, Long> {

         Turma  findByCodigo     (@Param("codigo")     String     codigo);
    List<Turma> findBySala       (@Param("sala")       String     sala);
    List<Turma> findByTurno      (@Param("turno")      char       turno);
    List<Turma> findByProfessor  (@Param("professor")  Professor  professor);
    List<Turma> findByDisciplina (@Param("disciplina") Disciplina disciplina);

}

// OK