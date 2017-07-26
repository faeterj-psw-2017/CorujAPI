package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

public interface TrabalhoRepository extends
    PagingAndSortingRepository<Trabalho, Long> {

	Trabalho findById (long id);
    List<Trabalho> findByTitulo (String titulo);
    List<Trabalho> findByAluno  (Aluno  aluno);
    List<Trabalho> findByTurma  (Turma  turma);

}

// OK
