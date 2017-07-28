package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Calendario;

public interface CalendarioRepository extends
    PagingAndSortingRepository<Calendario, Long> {

}

// OK
