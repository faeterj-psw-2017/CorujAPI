package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Grade;

public interface GradeRepository extends
    PagingAndSortingRepository<Grade, Long> {

}

// OK
