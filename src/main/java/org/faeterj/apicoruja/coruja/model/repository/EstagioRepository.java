package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;

@Repository
public interface EstagioRepository extends
    PagingAndSortingRepository<Estagio, Long> {

}

// OK
