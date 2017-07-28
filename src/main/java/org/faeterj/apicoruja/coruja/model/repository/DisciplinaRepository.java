package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

public interface DisciplinaRepository extends
        PagingAndSortingRepository<Disciplina, Long> {

		List<Disciplina>  findByAllNome         (String nome);
        List<Disciplina>  findByAllSigla        (String sigla);
        List<Disciplina> findByAllCargaHoraria (Double cargaHoraria);
        Disciplina  findByNome         (String nome);
        Disciplina  findBySigla        (String sigla);
        Disciplina findByCargaHoraria (Double cargaHoraria);
        Disciplina findByDescricao    (String descricao);
        List<Disciplina> findAll ();

}

// OK
