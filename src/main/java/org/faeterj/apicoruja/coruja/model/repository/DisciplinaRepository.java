package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;

public interface DisciplinaRepository extends
        PagingAndSortingRepository<Disciplina, Long> {

        List<Disciplina> findByNome         (String nome);
        List<Disciplina> findByCargaHoraria (Double cargaHoraria);
        List<Disciplina> findByDescricao    (String descricao);

}

// OK
