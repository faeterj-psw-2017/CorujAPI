package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

@Repository
@RepositoryRestResource(path="/aluno-page")
public interface AlunoRepository extends
    PagingAndSortingRepository<Aluno, Long> {

    List<Aluno> findByNome      (@Param("nome")      String nome);
         Aluno  findByMatricula (@Param("matricula") String matricula);
    List<Aluno> findBySexo      (@Param("sexo")      char   sexo);
    List<Aluno> findByEndereco  (@Param("endereco")  String endereco);
    List<Aluno> findByTelefone  (@Param("telefone")  String telefone);
         Aluno  findByCpf       (@Param("cpf")       String cpf);
         Aluno  findByRg        (@Param("rg")        String rg);

}

// OK
