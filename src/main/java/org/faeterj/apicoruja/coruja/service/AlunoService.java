package org.faeterj.apicoruja.coruja.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	private AlunoRepository repository;

    @Autowired
    public AlunoService (AlunoRepository alunoRepositorio) {
        this.repository = alunoRepositorio;
    }

	@PostConstruct
	public void init ( ) {
        BootMessage.log (this);
    }
	
	// ===================================================================
	
	public boolean apagarPorMatricula (String matricula) {
		Aluno aluno = obterPorMatricula (matricula);

		if (aluno == null) {
			return false;
		}

		repository.delete (aluno.getId ( ));
		return true;
	}

    // -------------------------------------------------------------
    
	public Aluno obterPorMatricula (String matricula) {
        return repository.findByMatricula (matricula);
	}

	public boolean adicionar (Aluno aluno) {
    	Aluno existente = obterPorMatricula (aluno.getMatricula ( ));

    	if (existente == null) {
    		repository.save (aluno);
    		return true;
    	}

    	return false;
	}
	
	// --------------------------------------------------------------

	public Aluno alterarPorMatricula (Aluno novo) {
    	Aluno existente = obterPorMatricula (novo.getMatricula ( ));

    	if (existente == null) {
    		return existente;
    	}

    	// impede que alguem limpe o historico caso este exista
    	if (novo.getHistorico ( ) == null) {
    		novo.setHistorico (existente.getHistorico ( ));
    	}
    	
    	novo.setId (existente.getId ( ));
    	repository.save (novo);

    	return novo;
	}

	public boolean apagar (long id) {
		Aluno aluno = repository.findOne (id);

		if (aluno == null) {
			return false;
		}

		repository.delete (id);
		return true;
	}

	public List<Aluno> listar ( ) {
		Iterable<Aluno> it = repository.findAll ( );
		List<Aluno> list   = new ArrayList<Aluno> ( );

		for (Aluno aluno : it) {
			list.add (aluno);
		}

		return list;
	}

	// --------------------------------------------------------------------
	
	public Aluno obter (long id) {
		return repository.findOne (id);
	}

}

// OK