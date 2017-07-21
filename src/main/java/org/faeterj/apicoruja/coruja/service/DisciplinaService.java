package org.faeterj.apicoruja.coruja.service;

import org.apache.commons.collections.IteratorUtils;
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
    public void init() {
        System.out.println("Criado modelo de disciplinas...");
        Disciplina d = new Disciplina( 1, "Algoritmo e Linguagem de Programação 1", 180.0, "Disciplina que ensina os fundamentos da programação." );

        repo.save(d);
    }

    public List<Disciplina> obterDisciplinas() {
        Iterator it = repo.findAll().iterator(); // De Repository para Iterator
        return IteratorUtils.toList( it ); // De Iterator para List
    }

    public Disciplina adicionarDisciplina(String nome, Double cargaHoraria, String descricao) {
        long id = 0L;
        List<Disciplina> disciplinas = this.obterDisciplinas();
        for (Disciplina d : disciplinas) {
            if (d.getId() > id) {
                id = d.getId();
            }
        }
        id++;
        Disciplina d = new Disciplina(id, nome, cargaHoraria, descricao);
        repo.save(d);
        return d;
    }

}
