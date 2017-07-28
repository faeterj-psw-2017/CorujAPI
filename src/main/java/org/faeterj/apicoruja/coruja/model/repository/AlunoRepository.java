package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

public interface AlunoRepository extends
    PagingAndSortingRepository<Aluno, Long> {

    List<Aluno> findByNome      (String nome);
         Aluno  findByMatricula (String matricula);
    List<Aluno> findBySexo      (char   sexo);
    List<Aluno> findByEndereco  (String endereco);
    List<Aluno> findByTelefone  (String telefone);
         Aluno  findByCpf       (String cpf);
         Aluno  findByRg        (String rg);

}

// OK
