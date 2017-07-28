package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;

public interface EstagioRepository extends
    PagingAndSortingRepository<Estagio, Long> {

}

// OK
