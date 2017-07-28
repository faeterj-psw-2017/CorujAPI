package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Professor;

@RepositoryRestResource(path="/professor-page")
@Repository
public interface ProfessorRepository extends
    PagingAndSortingRepository<Professor, Long> {

         Professor  findByMatricula (@Param("matricula") String matricula);
    List<Professor> findByNome      (@Param("nome")      String nome);
    List<Professor> findByEndereco  (@Param("endereco")  String endereco);
    List<Professor> findByTelefone  (@Param("telefone")  String telefone);
    List<Professor> findBySexo      (@Param("sexo")      char   sexo);
         Professor  findByRg        (@Param("rg")        String rg);
         Professor  findByCpf       (@Param("cpf")       String cpf);

}

// OK
