package org.faeterj.apicoruja.coruja.service;

import org.apache.commons.collections.IteratorUtils;
import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Modified by William Lemos on 23/07/17.
 */

/**
 * Created by Marcos Felipe on 19/07/17.
 */
@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repo;

    @PostConstruct
    public void init ( ) {
        BootMessage.log (this);
    }

    // =============================================================
    
    /*
    public Disciplina adicionarDisciplina (Disciplina d) {
        repo.save (d);
        return d;
    }
    */

    public boolean adicionarDisciplina (Disciplina nova) {
    	if (nova == null) {
    		return false;
    	}

    	repo.save (nova);
    	return true;
    }
    
    // ---------------------------------------------------------------
    
    public void alterarDisciplina (Disciplina d) {
        repo.save (d);
    }
    
    /*
    public boolean alterarDisciplina (String siglaAntiga, Disciplina Alterar) {
    	Disciplina remover = disciplinaRepository.findBySigla(siglaAntiga);
    	try{
    		disciplinaRepository.delete(remover);
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    	
    	return true;
    }
    */
    
    // ---------------------------------------------------------------------
    
    public List<Disciplina> obterDisciplinas ( ) {
        Iterator it = repo.findAll ( ).iterator ( ); // De Repository para Iterator
        return IteratorUtils.toList (it);            // De Iterator para List
    }

    public List<Disciplina> obterDisciplinaPorNome (String nome) {
        return repo.findByNomeIgnoreCaseContaining (nome);
    }

    public List<Disciplina> obterDisciplinaPorCargaHoraria (Double cargaHoraria) {
        return repo.findByCargaHoraria (cargaHoraria);
    }

    public List<Disciplina> obterDisciplinaPorDescricao (String descricao) {
        return repo.findByDescricaoIgnoreCaseContaining (descricao);
    }

    public Disciplina obterDisciplinaPorSigla (String sigla) {
        return repo.findBySiglaIgnoreCase (sigla);
    }

    public List<Disciplina> obterTodasDisciplinas ( ) {
        Iterable<Disciplina> iterable = repo.findAll ( );
        List<Disciplina> discs        = new ArrayList<Disciplina> ( );

        for (Disciplina disc : iterable) {
        	discs.add (disc);
        }

        return discs;
    }
    
    /*
    public List<Disciplina> obterDisciplinaPorSigla (String sigla) {
    	return repository.findByAllSigla (sigla);
    }
    */
    
    public List<Disciplina> obterDisciplinaCargaHoraria (Double cargaHoraria) {
    	return repo.findByCargaHoraria (cargaHoraria);
    }    
    // ----------------------------------------------------

    /*
    public void removerDisciplina (Disciplina d) {
        repo.delete (d.getId ( ));
    }
    */

    public boolean removerDisciplina (String sigla) {
    	Disciplina remover = repo.findBySigla (sigla);

    	try {
    		repo.delete (remover);
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    	
    	return true;
    }

}

// OK