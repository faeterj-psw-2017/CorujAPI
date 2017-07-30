package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

/**
 * Created by William Lemos on 23/07/17.
 */
@RepositoryRestResource(path="/turma-page")
public interface TurmaRepository extends
    PagingAndSortingRepository<Turma, Long> {

	@RestResource(path="/codigo", rel="codigo")
	Turma findByCodigo (@Param("codigo") String codigo);
	
	@RestResource(path="/sala", rel="sala")
    List<Turma> findBySala (@Param("sala") String sala);

	@RestResource(path="/turno", rel="turno")
    List<Turma> findByTurno (@Param("turno") char turno);

	@RestResource(path="/professor", rel="professor")
    List<Turma> findByProfessor (@Param("professor") Professor professor);

	@RestResource(path="/disciplina", rel="disciplina")
    List<Turma> findByDisciplina (
    	@Param("disciplina") Disciplina disciplina
    );

    // -------------------------------------------------------------------
    
    @Override
    @RestResource(exported=false)
    void delete (Long id);
    
    @Override
    @RestResource(exported=false)
    void delete (Turma turma);

    @Override
    @RestResource(exported=false)
    Turma save (Turma turma);

}

// OK