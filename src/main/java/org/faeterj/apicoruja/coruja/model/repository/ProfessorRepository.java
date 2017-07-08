package org.faeterj.apicoruja.faeterj.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.faeterj.apicoruja.coruja.model.entity.Professor;

// @RepositoryRestResource(collectionResourceRel="professor", path="professores")
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {

    List<Professor> findById        (@Param("atcom_id")  long   id);
    List<Professor> findByMatricula (@Param("matricula") long   matricula);
    List<Professor> findByNome      (@Param("nome")      String nome);
    List<Professor> findByEndereco  (@Param("endereco")  String endereco);
    List<Professor> findByTelefone  (@Param("telefone")  String telefone);
    List<Professor> findBySexo      (@Param("sexo")      char   sexo);

}

// OK
