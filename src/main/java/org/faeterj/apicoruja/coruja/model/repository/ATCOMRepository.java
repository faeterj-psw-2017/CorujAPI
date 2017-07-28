package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

@RepositoryRestResource(path="/atcom-page")
@Repository
public interface ATCOMRepository extends
    PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricao       (@Param("descricao")        String  descricao);
    List<ATCOM> findByHorasAtribuidas (@Param("horas_atribuidas") double  horasAtribuidas);
    List<ATCOM> findByValido          (@Param("valido")           boolean valido);
    List<ATCOM> findByAluno           (@Param("aluno")            Aluno   aluno);

}

// OK
