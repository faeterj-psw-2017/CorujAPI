package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by William Lemos on 23/07/17.
 */
@Service
public class TurmaService {

    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    
    public List<Turma> obterTodasTurmas() {

        return turmaRepository.findAll();

    }
    
    public List<Turma> obterTurmasCodigo(String codigo) {

        return turmaRepository.findByCodigo(codigo);

    }
    
    public List<Turma> obterTurmasTurno(char turno) {

        return turmaRepository.findByTurno(turno);

    }

    public boolean adicionarTurma(Turma Novo) {
    	
    	Turma test = turmaRepository.save(Novo);
    	if (test != null)
    		return true;
    	return false;

    }
    
    public boolean removerTurma (Turma remover) {
    	
    	List<Turma> procurar = turmaRepository.findAll();
    	for (Turma a : procurar)
    	{
    		if ( ( ( a.getCodigo().equals(remover.getCodigo()) ) && ( a.getSala().equals(remover.getSala()) ) ) && ( a.getTurno()==remover.getTurno() ))
    		{
    			turmaRepository.delete(a);
    			return true;
    		}
    			
    	}
    	return false;
    }
    
    public void alterarTurma (Turma original, Turma alterar) {
    	
    	List<Turma> procurar = turmaRepository.findAll();
    	for (Turma a : procurar)
    	{
    		if ( ( ( a.getCodigo().equals(original.getCodigo()) ) && ( a.getSala().equals(original.getSala()) ) ) && ( a.getTurno()==original.getTurno() ))
    		{
    			turmaRepository.delete(a);
    			turmaRepository.save(alterar);
    		}
    			
    	}
    }

}
