package org.faeterj.apicoruja.faeterj.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Historico;

public interface HistoricoRepository extends
    PagingAndSortingRepository<Historico, Long> {

}

// OK
