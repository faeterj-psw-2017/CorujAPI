package org.faeterj.apicoruja.coruja.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Grade;

@RepositoryRestResource(path="/grade-page")
public interface GradeRepository extends
    PagingAndSortingRepository<Grade, Long> {

	// TODO

	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Grade grade);

	@Override
	@RestResource(exported=false)
	Grade save (Grade grade);

}

// OK
