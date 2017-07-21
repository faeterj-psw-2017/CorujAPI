package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

// @RepositoryRestResource(collectionResourceRel="professor", path="professores")
public interface TurmaRepository extends PagingAndSortingRepository<Turma, Long> {
	public Turma findTurmaByCodigo(@Param("codigo") String   codigo);
}

// OK
