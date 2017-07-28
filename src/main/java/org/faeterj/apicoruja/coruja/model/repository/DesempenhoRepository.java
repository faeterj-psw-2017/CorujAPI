package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@Repository
public interface DesempenhoRepository extends
    PagingAndSortingRepository<Desempenho, Long> {

	List<Desempenho> findByAluno          (Aluno   aluno);
	List<Desempenho> findByTurma          (Turma   turma);
    List<Desempenho> findByNotaAv1        (Double  notaAv1);
    List<Desempenho> findByNotaAv2        (Double  notaAv2);
    List<Desempenho> findByNotaAvs        (Double  notaAvs);
    List<Desempenho> findByNotaAvf        (Double  notaAvf);
    List<Desempenho> findBySegundaChamada (boolean segundaChamada);
    List<Desempenho> findByRecuperacao    (boolean recuperacao);

}

// OK
