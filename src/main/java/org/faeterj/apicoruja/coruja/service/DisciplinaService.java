package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by William Lemos on 23/07/17.
 */
@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }
    
    public List<Disciplina> obterTodasDisciplinas() {

        return disciplinaRepository.findAll();

    }
    
    public List<Disciplina> obterDisciplinaPorSigla (String sigla) {
    	return disciplinaRepository.findByAllSigla(sigla);
    }
    
    public List<Disciplina> obterDisciplinaCargaHoraria (Double cargaHoraria) {
    	return disciplinaRepository.findByAllCargaHoraria(cargaHoraria);
    }
    
    public boolean adicionarDisciplina (Disciplina nova) {
    	Disciplina test = disciplinaRepository.save(nova);
    	if (test != null)
    		return true;
    	return false;
    }
    
    public boolean removerDisciplina (String sigla) {
    	Disciplina remover = disciplinaRepository.findBySigla(sigla);
    	try{
    		disciplinaRepository.delete(remover);
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    	
    	return true;
    }
    
    public boolean alterarDisciplina (String siglaAntiga, Disciplina Alterar) {
    	Disciplina remover = disciplinaRepository.findBySigla(siglaAntiga);
    	try{
    		disciplinaRepository.delete(remover);
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    	
    	return true;
    }

}
