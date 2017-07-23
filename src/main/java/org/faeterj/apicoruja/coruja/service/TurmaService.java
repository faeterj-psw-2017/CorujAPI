package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.entity.TurmaAlunoNotas;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
import org.faeterj.apicoruja.model.embeddable.TurmaAlunosId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
	
	TurmaRepository turmaRepository;
	@Autowired
	public void setProfessorRepository(TurmaRepository turmaRepository){
		this.turmaRepository=turmaRepository;
	}
	
    public List<Turma> obterTurmas() {
        return (List<Turma>) turmaRepository.findAll();
    }
    
    public Turma obterTurma(String codigo){
    	return turmaRepository.findTurmaByCodigo(codigo);
    }
    
    public void excluirTurma(Turma turma){
    	turmaRepository.delete(turma);
    }

    public boolean adicionaProfessor(String codigo, Professor professor){
    	Turma turma = turmaRepository.findTurmaByCodigo(codigo);
    	if(turma!=null){
    		turma.setProfessor(professor);
    		turmaRepository.save(turma);
    		return true;
    	}
    	return false;
    }
    
    public boolean removerProfessor(String codigo, Professor professor){
    	Turma turma = turmaRepository.findTurmaByCodigo(codigo);
    	if(turma!=null){
    		if(professor==turma.getProfessor()){
    			turma.setProfessor(null);
    			turmaRepository.save(turma);
        		return true;
    		}
    	}
    	return false;
    }
    
    public void salvarTurma(Turma turma){
    	turmaRepository.save(turma);
    }
    
    public boolean adicionaAluno(String codigo, Aluno aluno){
    	Turma turma = turmaRepository.findTurmaByCodigo(codigo);
    	if(turma!=null){
    		TurmaAlunosId id = new TurmaAlunosId();
    		id.setTurma(turma);
    		id.setAluno(aluno);
    		TurmaAlunoNotas turmaAluno = new TurmaAlunoNotas();
    		turmaAluno.setId(id);
    		turma.setAlunos(turmaAluno);
    		turmaRepository.save(turma);
    		return true;
    	}
    	return false;
    }
    
    public boolean lancarNotaAv1(Turma turma, TurmaAlunoNotas aluno, float nota){
    	if(turma!=null){
    		aluno.setNotaAv1(nota);
    		turma.setAlunos(aluno);
    		turmaRepository.save(turma);
    		return true;
    	}
    	return false;
    }
    
    public boolean lancarNotaAv2(Turma turma, TurmaAlunoNotas aluno, float nota){
    	if(turma!=null){
    		aluno.setNotaAv2(nota);
    		turma.setAlunos(aluno);
    		turmaRepository.save(turma);
    		return true;
    	}
    	return false;
    }
    
    public boolean lancarNotaAvf(Turma turma, TurmaAlunoNotas aluno, float nota){
    	if(turma!=null){
    		aluno.setNotaAvf(nota);
    		turma.setAlunos(aluno);
    		turmaRepository.save(turma);
    		return true;
    	}
    	return false;
    }

}
