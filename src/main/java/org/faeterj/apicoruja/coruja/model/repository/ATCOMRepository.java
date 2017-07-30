package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="/atcom-page")
public interface ATCOMRepository extends
        PagingAndSortingRepository<ATCOM, Long> {

	@RestResource(path="/descricao", rel="descricao")
    List<ATCOM> findByDescricao (@Param("descricao") String descricao);

	@RestResource(path="/horas-atribuidas", rel="horas-atribuidas")
    List<ATCOM> findByHorasAtribuidas (
    	@Param("horas_atribuidas") double horasAtribuidas
    );

	@RestResource(path="/valido", rel="valido")
    List<ATCOM> findByValido (@Param("valido") boolean valido);

	@RestResource(path="/aluno", rel="aluno")
    List<ATCOM> findByAluno (@Param("aluno") Aluno aluno);

	@RestResource(path="/validado", rel="validado")
	List<ATCOM> findByAlunoAndValido (@Param("aluno")  Aluno aluno,
			                          @Param("valido") boolean valido);
	
	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (ATCOM atcom);
    
	@Override
	@RestResource(exported=false)
	ATCOM save (ATCOM atcom);
	
}

// OK
