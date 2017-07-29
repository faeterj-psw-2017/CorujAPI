package org.faeterj.apicoruja.coruja.service;

import org.apache.commons.collections.IteratorUtils;
import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.model.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

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

    public Disciplina adicionarDisciplina (Disciplina d) {
        repo.save (d);
        return d;
    }

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

    // ----------------------------------------------------
    
    public void alterarDisciplina (Disciplina d) {
        repo.save (d);
    }

    public void removerDisciplina (Disciplina d) {
        repo.delete (d.getId ( ));
    }

}
