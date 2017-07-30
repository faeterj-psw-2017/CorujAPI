package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@RepositoryRestResource(path="/desempenho-page")
public interface DesempenhoRepository extends
    PagingAndSortingRepository<Desempenho, Long> {

	@RestResource(path="/aluno", rel="aluno")
	List<Desempenho> findByAluno (@Param("aluno") Aluno aluno);

	@RestResource(path="/turma", rel="turma")
	List<Desempenho> findByTurma (@Param("turma") Turma turma);

	@RestResource(path="/AV1", rel="AV1")
    List<Desempenho> findByNotaAv1 (@Param("nota") Double notaAv1);

	@RestResource(path="/AV2", rel="AV2")
    List<Desempenho> findByNotaAv2 (@Param("nota") Double notaAv2);

	@RestResource(path="/AVS", rel="AVS")
    List<Desempenho> findByNotaAvs (@Param("nota") Double notaAvs);

	@RestResource(path="/AVF", rel="AVF")
    List<Desempenho> findByNotaAvf (@Param("nota") Double notaAvf);

	@RestResource(path="/segunda-chamada", rel="segunda-chamada")
    List<Desempenho> findBySegundaChamada (
    	@Param("flag") boolean segundaChamada
    );

	@RestResource(path="/recuperacao", rel="recuperacao")
    List<Desempenho> findByRecuperacao (@Param("flag") boolean recuperacao);

	// -------------------------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Desempenho desempenho);	
	
	@Override
	@RestResource
	Desempenho save (Desempenho desempenho);
	
}

// OK
