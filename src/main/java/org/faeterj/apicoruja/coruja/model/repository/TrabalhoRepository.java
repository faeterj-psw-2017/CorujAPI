package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

@RepositoryRestResource(path="/trabalho-page")
public interface TrabalhoRepository extends
    PagingAndSortingRepository<Trabalho, Long> {

	@RestResource(path="/titulo", rel="titulo")
    List<Trabalho> findByTitulo (@Param("titulo") String titulo);

	@RestResource(path="/aluno", rel="aluno")
    List<Trabalho> findByAluno (@Param("aluno") Aluno aluno);

	@RestResource(path="/turma", rel="turma")
    List<Trabalho> findByTurma (@Param("turma") Turma turma);

	@RestResource(path="/all", rel="all")
    Trabalho findByTituloAndAlunoAndTurma (
    	@Param("titulo") String titulo,
    	@Param("aluno")  Aluno  aluno,
    	@Param("turma")  Turma  turma
    );

	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Trabalho trabalho);

	@Override
	@RestResource(exported=false)
	Trabalho save (Trabalho trabalho);
	
}

// OK
