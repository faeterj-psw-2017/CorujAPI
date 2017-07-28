package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Calendario;

@Repository
@RepositoryRestResource(path="/calendario-page")
public interface CalendarioRepository extends
    PagingAndSortingRepository<Calendario, Long> {

	// TDOD

}

// OK
