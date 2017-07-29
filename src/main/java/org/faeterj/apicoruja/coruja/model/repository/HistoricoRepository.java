package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Historico;

@Repository
@RepositoryRestResource(path="/historico-page")
public interface HistoricoRepository extends
    PagingAndSortingRepository<Historico, Long> {

	// TODO
	
}

// OK
