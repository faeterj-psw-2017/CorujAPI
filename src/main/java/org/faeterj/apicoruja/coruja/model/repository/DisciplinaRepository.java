package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends
        PagingAndSortingRepository<Disciplina, Long> {

             Disciplina  findByNome         (String nome);
             Disciplina  findBySigla        (String sigla);
        List<Disciplina> findByCargaHoraria (Double cargaHoraria);
             Disciplina  findByDescricao    (String descricao);

}

// OK
