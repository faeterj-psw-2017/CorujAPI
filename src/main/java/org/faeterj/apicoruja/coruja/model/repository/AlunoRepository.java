package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

@RepositoryRestResource(path="/aluno-page")
public interface AlunoRepository extends
    PagingAndSortingRepository<Aluno, Long> {

	@RestResource(path="/nome", rel="nome")
    List<Aluno> findByNome (@Param("nome") String nome);

	@RestResource(path="/matricula", rel="matricula")
    Aluno findByMatricula (@Param("matricula") String matricula);

	@RestResource(path="/sexo", rel="sexo")
    List<Aluno> findBySexo (@Param("sexo") char sexo);

	@RestResource(path="/endereco", rel="endereco")
    List<Aluno> findByEndereco (@Param("endereco") String endereco);

	@RestResource(path="/telefone", rel="telefone")
    List<Aluno> findByTelefone (@Param("telefone") String telefone);

	@RestResource(path="/CPF", rel="CPF")
    Aluno findByCpf (@Param("CPF") String cpf);

	@RestResource(path="/RG", rel="RG")
    Aluno findByRg (@Param("RG") String rg);

	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Aluno aluno);

	@Override
	@RestResource(exported=false)
	Aluno save (Aluno aluno);
	
}

// OK
