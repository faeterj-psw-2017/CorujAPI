package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@Repository
@RepositoryRestResource(path="/trabalho-page")
public interface TrabalhoRepository extends
    PagingAndSortingRepository<Trabalho, Long> {

    List<Trabalho> findByTitulo (@Param("titulo") String titulo);
    List<Trabalho> findByAluno  (@Param("aluno")  Aluno  aluno);
    List<Trabalho> findByTurma  (@Param("turma")  Turma  turma);

}

// OK
