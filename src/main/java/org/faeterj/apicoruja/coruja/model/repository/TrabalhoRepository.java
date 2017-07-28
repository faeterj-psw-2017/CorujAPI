package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@Repository
public interface TrabalhoRepository extends
    PagingAndSortingRepository<Trabalho, Long> {

    List<Trabalho> findByTitulo (String titulo);
    List<Trabalho> findByAluno  (Aluno  aluno);
    List<Trabalho> findByTurma  (Turma  turma);

}

// OK
