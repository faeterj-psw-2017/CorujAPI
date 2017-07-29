package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@Repository
@RepositoryRestResource(path="/desempenho-page")
public interface DesempenhoRepository extends
    PagingAndSortingRepository<Desempenho, Long> {

	List<Desempenho> findByAluno          (@Param("aluno")           Aluno   aluno);
	List<Desempenho> findByTurma          (@Param("turma")           Turma   turma);
    List<Desempenho> findByNotaAv1        (@Param("nota_av1")        Double  notaAv1);
    List<Desempenho> findByNotaAv2        (@Param("nota_av2")        Double  notaAv2);
    List<Desempenho> findByNotaAvs        (@Param("nota_avs")        Double  notaAvs);
    List<Desempenho> findByNotaAvf        (@Param("nota_avf")        Double  notaAvf);
    List<Desempenho> findBySegundaChamada (@Param("segunda_chamada") boolean segundaChamada);
    List<Desempenho> findByRecuperacao    (@Param("recuperacao")     boolean recuperacao);

}

// OK
