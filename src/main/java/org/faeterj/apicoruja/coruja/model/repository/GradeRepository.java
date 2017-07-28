package org.faeterj.apicoruja.coruja.model.repository;

// import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Grade;

@Repository
public interface GradeRepository extends
    PagingAndSortingRepository<Grade, Long> {

}

// OK
