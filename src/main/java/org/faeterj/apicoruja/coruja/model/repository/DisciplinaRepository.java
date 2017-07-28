package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;

@Repository
@RepositoryRestResource(path="/disciplina-page")
public interface DisciplinaRepository extends
	PagingAndSortingRepository<Disciplina, Long> {

    /*
    	findBy:     - encontrar
    	IgnoreCase: - ignorar se é caixa alta ou baixa
    	Containing: - que contenha um texto, ou seja, não precisa ser exatamente o texto
    */
	
         Disciplina  findByNome                          (@Param("nome")          String nome);
         Disciplina  findBySigla                         (@Param("sigla")         String sigla);
    List<Disciplina> findByNomeIgnoreCaseContaining      (@Param("nome")          String nome);
    List<Disciplina> findByCargaHoraria                  (@Param("carga_horaria") Double cargaHoraria);
    List<Disciplina> findByDescricaoIgnoreCaseContaining (@Param("descricao")     String descricao);
         Disciplina  findBySiglaIgnoreCase               (@Param("sigla")         String sigla);

}

// OK