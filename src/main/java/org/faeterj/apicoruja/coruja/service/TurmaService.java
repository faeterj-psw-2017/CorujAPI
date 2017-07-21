package org.faeterj.apicoruja.coruja.service;

import java.util.List;


import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
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

}
