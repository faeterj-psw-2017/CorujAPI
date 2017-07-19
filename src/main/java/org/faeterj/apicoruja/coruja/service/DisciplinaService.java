package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos Felipe on 19/07/17.
 */
@Service
public class DisciplinaService {

    private List<Disciplina> disciplinas;

    @PostConstruct
    public void init() {
        System.out.println("Criado modelo de disciplinas...");
        Disciplina d = new Disciplina( 1, "Algoritmo e Linguagem de Programação 1", 180.0, "Disciplina que ensina os fundamentos da programação." );

        disciplinas = new ArrayList<Disciplina>();
        disciplinas.add(d);
    }

    public List<Disciplina> obterDisciplinas() {
        return disciplinas;
    }

    public Disciplina adicionarDisciplina(String nome, Double cargaHoraria, String descricao) {
        long id = 0L;
        for (Disciplina d : disciplinas) {
            if (d.getId() > id) {
                id = d.getId();
            }
        }
        id++;
        Disciplina d = new Disciplina( id, nome, cargaHoraria, descricao);
        disciplinas.add(d);
        return d;
    }

}
