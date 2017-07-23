package org.faeterj.apicoruja.coruja.model.repository;


import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.entity.TurmaAlunoNotas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

// @RepositoryRestResource(collectionResourceRel="professor", path="professores")
public interface TurmaAlunoNotasRepository extends PagingAndSortingRepository<TurmaAlunoNotas, Long> {
	TurmaAlunoNotas findByIdAluno        (@Param("aluno_aluno_id") Aluno aluno);
	TurmaAlunoNotas findByIdTurma        (@Param("turma_turma_id") Turma turma);
}

// OK
