package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;

// @RepositoryRestResource(collectionResourceRel="atcom", path="atcoms")
public interface ATCOMRepository extends PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricaoDocumento (@Param("descricao_documento") String  descricaoDocumento);
    List<ATCOM> findById                 (@Param("atcom_id")            long    id);
    List<ATCOM> findByHorasAtribuidas    (@Param("horas_atribuidas")    Double  horasAtribuidas);
    List<ATCOM> findByValido             (@Param("valido")              boolean valido);

}

// OK
