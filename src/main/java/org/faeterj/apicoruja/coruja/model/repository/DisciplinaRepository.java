package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;

@RepositoryRestResource(path="/disciplina-page")
public interface DisciplinaRepository extends
	PagingAndSortingRepository<Disciplina, Long> {

    /*
    	findBy...     : - encontrar
    	...IgnoreCase : - ignorar se é caixa alta ou baixa
    	...Containing : - que contenha um texto, ou seja, não precisa ser exatamente o texto
    */

	@RestResource(path="/name", rel="nome")
    Disciplina findByNome (@Param("nome") String nome);

	@RestResource(path="/sigla", rel="sigla")
    Disciplina findBySigla (@Param("sigla") String sigla);

	@RestResource(path="/contains-nome", rel="contains-nome")
    List<Disciplina> findByNomeIgnoreCaseContaining (
    	@Param("nome") String nome
    );

	@RestResource(path="/carga-horaria", rel="carga-horaria")
    List<Disciplina> findByCargaHoraria (
    	@Param("carga_horaria") Double cargaHoraria
    );

	@RestResource(path="/descricaco", rel="descricao")
    List<Disciplina> findByDescricao (@Param("descricao") String descricao);

	@RestResource(path="/contains-descricao", rel="contains-descricao")
    List<Disciplina> findByDescricaoIgnoreCaseContaining (
    	@Param("descricao") String descricao
    );

	@RestResource(path="/sigla-insensitive", rel="sigla-insensitive")
    Disciplina findBySiglaIgnoreCase (@Param("sigla") String sigla);

	// -----------------------------------------------------------------
	
	@Override
	@RestResource(exported=false)
	void delete (Long id);
	
	@Override
	@RestResource(exported=false)
	void delete (Disciplina disciplina);

	@Override
	@RestResource(exported=false)
	Disciplina save (Disciplina disciplina);

}

// OK