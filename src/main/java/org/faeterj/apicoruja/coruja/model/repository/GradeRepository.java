package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Grade;

@Repository
@RepositoryRestResource(path="/grade-page")
public interface GradeRepository extends
    PagingAndSortingRepository<Grade, Long> {

	// TODO
	
}

// OK
