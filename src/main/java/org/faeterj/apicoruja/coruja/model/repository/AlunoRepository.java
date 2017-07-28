package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

public interface AlunoRepository extends
    PagingAndSortingRepository<Aluno, Long> {

	//@Query("SELECT al.nome, al.telefone, al.endereco, al.matricula, al.sexo from aluno al WHERE al.nome LIKE '%?%'")
    List<Aluno> findByNomeIgnoreCaseContaining   (String nome);
    
         Aluno  findByMatricula (String matricula);
    List<Aluno> findBySexo      (char   sexo);
    List<Aluno> findByEndereco  (String endereco);
    List<Aluno> findByTelefone  (String telefone);

}

// OK
