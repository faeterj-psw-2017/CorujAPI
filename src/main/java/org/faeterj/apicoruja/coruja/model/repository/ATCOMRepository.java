package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

public interface ATCOMRepository extends
    PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricaoDocumento (String  descricaoDocumento);
    List<ATCOM> findByHorasAtribuidas    (Double  horasAtribuidas);
    List<ATCOM> findByValido             (boolean valido);
    List<ATCOM> findByAluno              (Aluno   aluno);
    ATCOM findById              (Long   id);
    ATCOM update(ATCOM atcom);
}

// OK
