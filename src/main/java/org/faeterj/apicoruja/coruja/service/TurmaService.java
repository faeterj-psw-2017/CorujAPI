package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public final class TurmaService {
	
	private final TurmaRepository turmaRepository;

	@Autowired
	public TurmaService (TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
	}
	
    public List<Turma> obterTurmas( ) {
        return (List<Turma>) turmaRepository.findAll ( );
    }
    
    public Turma obterTurma (String codigo) {
        return turmaRepository.findByCodigo (codigo);
    }
    
    public void excluirTurma (Turma turma) {
        turmaRepository.delete (turma);
    }

    public boolean adicionaProfessor (String codigo, Professor professor) {
        Turma turma = turmaRepository.findByCodigo (codigo);

        if (turma != null) {
            turma.setProfessor (professor);
            turmaRepository.save (turma);

            return true;
        }

        return false;
    }
    
    public boolean removerProfessor (String codigo, Professor professor) {
        Turma turma = turmaRepository.findByCodigo (codigo);

        if ((turma != null) && (professor == turma.getProfessor ( ))) {
            turma.setProfessor (null);
            turmaRepository.save (turma);

            return true;
        }

        return false;
    }
    
    public void salvarTurma (Turma turma) {
        turmaRepository.save (turma);
    }
    
    public boolean adicionaAluno (String codigo, Aluno aluno) {
        return false;
    }

}
