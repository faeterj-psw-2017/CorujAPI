package org.faeterj.apicoruja.coruja.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Historico;

@RepositoryRestResource(path="/historico-page")
public interface HistoricoRepository extends
    PagingAndSortingRepository<Historico, Long> {

	// TODO

	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Historico historico);

	@Override
	@RestResource(exported=false)
	Historico save (Historico historico);
	
}

// OK
