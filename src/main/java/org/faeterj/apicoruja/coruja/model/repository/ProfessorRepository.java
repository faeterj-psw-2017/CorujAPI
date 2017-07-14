package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

// @RepositoryRestResource(collectionResourceRel="professor", path="professores")
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {
	List<Professor> findById        (@Param("atcom_id")  long   id);
    Professor findByMatricula (@Param("matricula") String   matricula);
    List<Professor> findByNome      (@Param("nome")      String nome);
    List<Professor> findByEndereco  (@Param("endereco")  String endereco);
    List<Professor> findByTelefone  (@Param("telefone")  String telefone);

}

// OK
