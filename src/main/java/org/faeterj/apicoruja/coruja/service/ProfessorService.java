package org.faeterj.apicoruja.coruja.service;

import java.util.ArrayList;
import java.util.List;
import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public final class ProfessorService {

	private ProfessorRepository repository;
	
	@Autowired
	public ProfessorService (ProfessorRepository repository) {
        this.repository = repository;
	}

    @PostConstruct
    public void init ( ) {
    	BootMessage.log (this);
    }

    // -----------------------------------------------------------
    
	public void salvar (Professor professor) {
        // no banco existem constraints contra atributos nulos
        if (
        	professor.getNome ( )      != null &&
            professor.getMatricula ( ) != null &&
            professor.getEndereco ( )  != null &&
            professor.getTelefone ( )  != null &&
            professor.getCpf ( )       != null &&
            professor.getRg ( )        != null
        ) {
    	    repository.save (professor);
        }
	}
	
	public boolean editar (
		String matricula, String nome,
		String endereco, String telefone
	) {
	    Professor professor = repository.findByMatricula (matricula);

	    // o professor pode ser alterado, desde que seu nome nao seja nulo
	    // ou seja, todo o resto de atributos (com excecao da matricula, rg
	    // e cpf), pode ser modificado sem problemas
	    if ((professor != null) && (nome != null)) {
	    	professor.setNome     (nome);
	    	professor.setEndereco (endereco);
	    	professor.setTelefone (telefone);

		    repository.save (professor);

		    return true;
	    }

	    return false;
	}
	
	public List<Professor> listar ( ) {
        Iterable<Professor> iterable = repository.findAll ( );
        List<Professor> professores  = new ArrayList<Professor> ( );

        for (Professor prof : iterable) {
        	professores.add (prof);
        }
        
        return professores;
	}
	
	// ----------------------------------------------------------------
	
	public boolean excluir (String matricula) {
	    Professor professor = repository.findByMatricula (matricula);

	    if (professor == null) {
		    return false;
	    }

        repository.delete (professor.getId ( ));
        
        return true;
	}
	
	// ---------------------------------------------------------------------
	
	public Professor encontrarPorMatricula (String matricula) {
        return repository.findByMatricula (matricula);
	}
	
	public List<Professor> encontrarPorEndereco (String endereco) {
        return repository.findByEndereco (endereco);
	}
	
	public List<Professor> encontrarPorNome (String nome) {
        return repository.findByNome (nome);
	}
	
	public List<Professor> encontrarPorTelefone (String telefone) {
        return repository.findByTelefone (telefone);
	}

	public List<Professor> encontrarPorSexo (char sexo) {
		return repository.findBySexo (sexo);
	}

	// ------------------------------------------------------------------
	
	public Professor obter (long id) {
		return repository.findOne (id);
	}

}

// OK