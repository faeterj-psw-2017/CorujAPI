package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends
	PagingAndSortingRepository<Disciplina, Long> {

    /*
    	findBy:     - encontrar
    	IgnoreCase: - ignorar se é caixa alta ou baixa
    	Containing: - que contenha um texto, ou seja, não precisa ser exatamente o texto
    */
	
         Disciplina  findByNome                          (String nome);
         Disciplina  findBySigla                         (String sigla);
    List<Disciplina> findByNomeIgnoreCaseContaining      (String nome);
    List<Disciplina> findByCargaHoraria                  (Double cargaHoraria);
    List<Disciplina> findByDescricaoIgnoreCaseContaining (String descricao);
         Disciplina  findBySiglaIgnoreCase               (String sigla);

}

// OK