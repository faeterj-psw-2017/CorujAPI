package org.faeterj.apicoruja.coruja.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Calendario;

@RepositoryRestResource(path="/calendario-page")
public interface CalendarioRepository extends
    PagingAndSortingRepository<Calendario, Long> {

	// TODO
	
	// ---------------------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Calendario calendario);

	@Override
	@RestResource(exported=false)
	Calendario save (Calendario calendario);

}

// OK
