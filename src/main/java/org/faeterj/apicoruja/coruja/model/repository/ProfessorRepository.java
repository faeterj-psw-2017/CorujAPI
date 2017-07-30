package org.faeterj.apicoruja.coruja.model.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.faeterj.apicoruja.coruja.model.entity.Professor;

@RepositoryRestResource(path="/professor-page")
public interface ProfessorRepository extends
    PagingAndSortingRepository<Professor, Long> {

	@RestResource(path="/matricula", rel="matricula")
    Professor findByMatricula (@Param("matricula") String matricula);

	@RestResource(path="/nome", rel="nome")
    List<Professor> findByNome (@Param("nome") String nome);

	@RestResource(path="/endereco", rel="nome")
    List<Professor> findByEndereco (@Param("endereco") String endereco);

	@RestResource(path="/telefone", rel="telefone")
    List<Professor> findByTelefone (@Param("telefone") String telefone);

	@RestResource(path="/sexo", rel="sexo")
    List<Professor> findBySexo (@Param("sexo") char sexo);

	@RestResource(path="/RG", rel="RG")
    Professor findByRg (@Param("rg") String rg);

    @RestResource(path="/CPF", rel="CPF")
    Professor findByCpf (@Param("cpf") String cpf);

	// --------------------------------------------------
	
	@Override
	@RestResource(exported=false)
	void delete (Long id);
	
	@Override
	@RestResource(exported=false)
	void delete (Professor professor);

	@Override
	@RestResource(exported=false)
	Professor save (Professor professor);

}

// OK
