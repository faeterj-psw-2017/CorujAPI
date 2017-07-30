package org.faeterj.apicoruja.coruja.service;

import java.util.ArrayList;
import java.util.List;
import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * Created by William Lemos on 23/07/17.
 */
@Service
public final class TurmaService {
	
	private final TurmaRepository repository;

	@Autowired
	public TurmaService (TurmaRepository repository) {
        this.repository = repository;
	}
	
	@PostConstruct
	public void init ( ) {
		BootMessage.log (this);
	}
	
    public List<Turma> obterTurmas( ) {
        return (List<Turma>) repository.findAll ( );
    }
    
    public Turma obterTurma (String codigo) {
        return repository.findByCodigo (codigo);
    }
    
    public void excluirTurma (Turma turma) {
        repository.delete (turma);
    }

    public boolean adicionaProfessor (String codigo, Professor professor) {
        Turma turma = repository.findByCodigo (codigo);

        if (turma != null) {
            turma.setProfessor (professor);
            repository.save (turma);

            return true;
        }

        return false;
    }
    
    public boolean removerProfessor (String codigo, Professor professor) {
        Turma turma = repository.findByCodigo (codigo);

        if (professor == turma.getProfessor ( )) {
            turma.setProfessor (null);
            repository.save (turma);

            return true;
        }

        return false;
    }
    
    public void salvarTurma (Turma turma) {
        repository.save (turma);
    }
    
    public boolean adicionaAluno (String codigo, Aluno aluno) {
        return false;
    }
    
    // ------------------------------------------------------------
    
    public List<Turma> obterTodasTurmas ( ) {
        Iterable<Turma> iterable = repository.findAll ( );
        List<Turma> turmas       = new ArrayList<Turma> ( );

        for (Turma turma : iterable) {
        	turmas.add (turma);
        }

        return turmas;
    }
    
    public Turma obterTurmaCodigo (String codigo) {
        return repository.findByCodigo (codigo);
    }
    
    public List<Turma> obterTurmasTurno (char turno) {
        return repository.findByTurno (turno);

    }

    public boolean adicionarTurma (Turma novo) {
    	if (novo == null) {
    		return false;
    	}

    	repository.save (novo);
    	return true;
    }

    // remove turma, primeiro por codigo, pois o id
    // de uma entidade vinda de fora do banco estara nulo
    public boolean removerTurma (Turma remover) {
    	Turma turma = repository.findByCodigo (remover.getCodigo ( ));

    	if (turma == null) {
    		return false;
    	}
    	
    	repository.delete (turma.getId ( ));
    	return true;
    }
    
    // TODO
    // refatorar pra sobrescrever pegando pelo codigo
    // e logo depois, pelo id, sem necessidade de 2 turmas passadas
    // pelo argumento
    public void alterarTurma (Turma original, Turma alterar) {    	
    	alterar.setCodigo (original.getCodigo ( ));

    	repository.save (alterar);
    }

}

// OK