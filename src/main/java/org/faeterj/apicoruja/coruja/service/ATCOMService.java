package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.repository.ATCOMRepository;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ATCOMService {

    private ATCOMRepository repository;
    private AlunoRepository alunoRepo;

    @Autowired
    public ATCOMService (
    	ATCOMRepository injected,
    	AlunoRepository injectedAluno
    ) {
        repository = injected;
        alunoRepo  = injectedAluno;
    }

    @PostConstruct
    public void init ( ) {
    	BootMessage.log (this);
    }

    // =====================================================================
    
    public ATCOM criar (ATCOM atcom) {
    	atcom.setId (null);
    	// impede que entradas existentes
    	// sejam sobrescritas
    	
        return repository.save (atcom);
    }

    public boolean apagar (long id) {
    	if (repository.findOne (id) == null) {
    		return false;
    	}

        repository.delete (id);
        return true;
    }

    public ATCOM atualizar (ATCOM atcom, long id) {
    	ATCOM existente = repository.findOne (atcom.getId ( ));

    	if (existente == null) {
    		return existente;
    	}
    	
        repository.save (atcom);
        return atcom;
    }

    public List<ATCOM> listar ( ) {
    	Iterable<ATCOM> id = repository.findAll ( );
    	List<ATCOM> list   = new ArrayList<> ( );
    	
    	for (ATCOM atcom : id) {
    		list.add(atcom);
    	}

    	return list;
    }

	public ATCOM obter (long id) {
		return repository.findOne (id);
	}

	// -------------------------------------------------

	public List<ATCOM> validos ( ) {
		return repository.findByValido (true);
	}

	public List<ATCOM> invalidos ( ) {
		return repository.findByValido (false);
	}

	public List<ATCOM> aluno (Aluno aluno) {
		return repository.findByAluno (aluno);
	}

	public List<ATCOM> validados (Aluno aluno, boolean flag) {
		return repository.findByAlunoAndValido (aluno, flag);
	}

	public List<ATCOM> aluno (Long id) {
		return aluno (alunoRepo.findOne (id));
	}

	public List<ATCOM> validadosDoAluno (boolean flag, long id) {
		Aluno aluno = alunoRepo.findOne (id);

		return validados (aluno, flag);
	}
	
}

// OK