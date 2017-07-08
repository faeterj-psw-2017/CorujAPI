package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;

// @RepositoryRestResource(collectionResourceRel="aluno", path="alunos")
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {

    List<Aluno> findByNome      (@Param("nome")      String nome);
    List<Aluno> findById        (@Param("aluno_id")  long   id);
    List<Aluno> findByMatricula (@Param("matricula") long   matricula);

}

// OK
