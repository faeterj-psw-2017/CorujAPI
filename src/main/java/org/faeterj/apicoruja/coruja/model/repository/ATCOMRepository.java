package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path="/atcom")
public interface ATCOMRepository extends
        PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricaoDocumento (String  descricaoDocumento);
    List<ATCOM> findByHorasAtribuidas    (Double  horasAtribuidas);
    List<ATCOM> findByValido             (boolean valido);
    List<ATCOM> findByAluno              (Aluno aluno);
}

// OK
