package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;

public interface ATCOMRepository extends
    PagingAndSortingRepository<ATCOM, Long> {

    List<ATCOM> findByDescricaoDocumento (String  descricaoDocumento);
    List<ATCOM> findById                 (long    id);
    List<ATCOM> findByHorasAtribuidas    (Double  horasAtribuidas);
    List<ATCOM> findByValido             (boolean valido);

}

// OK
