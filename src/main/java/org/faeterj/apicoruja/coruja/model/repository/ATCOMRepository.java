package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path="/atcom-page")
public interface ATCOMRepository extends
        PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricao       (@Param("descricao")        String  descricao);
    List<ATCOM> findByHorasAtribuidas (@Param("horas_atribuidas") Double  horasAtribuidas);
    List<ATCOM> findByValido          (@Param("valido")           boolean valido);
    List<ATCOM> findByAluno           (@Param("aluno")            Aluno   aluno);
}

// OK
