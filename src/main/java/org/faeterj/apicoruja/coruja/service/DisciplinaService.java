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
        System.out.println("Criado modelo de disciplinas..."); // Criando algumas disciplinas para testar
        this.adicionarDisciplina("Algoritmo e Linguagem de Programação 1", 180.0, "Disciplina que ensina os fundamentos da programação.", "AL1");
        this.adicionarDisciplina("Algoritmo e Linguagem de Programação 2", 220.0, "teste...", "AL2");
    }

    public Disciplina adicionarDisciplina(String nome, Double cargaHoraria, String descricao, String sigla) {
        long id = 0L;
        List<Disciplina> disciplinas = this.obterDisciplinas();
        for (Disciplina d : disciplinas) {
            if (d.getId() > id) {
                id = d.getId();
            }
        }
        id++;
        Disciplina d = new Disciplina(id, nome, cargaHoraria, descricao, sigla);
        repo.save(d);
        return d;
    }

    public List<Disciplina> obterDisciplinas() {
        Iterator it = repo.findAll().iterator(); // De Repository para Iterator
        return IteratorUtils.toList( it ); // De Iterator para List
    }

    public List<Disciplina> obterDisciplinaPorNome(String nome) {
        return repo.findByNomeIgnoreCaseContaining(nome);
    }

    public List<Disciplina> obterDisciplinaPorCargaHoraria(Double cargaHoraria) {
        return repo.findByCargaHoraria(cargaHoraria);
    }

    public List<Disciplina> obterDisciplinaPorDescricao(String descricao) {
        return repo.findByDescricaoIgnoreCaseContaining(descricao);
    }

    public Disciplina obterDisciplinaPorSigla(String sigla) {
        return repo.findBySiglaIgnoreCase(sigla);
    }

    public void alterarDisciplina(Disciplina d) {
        repo.save(d);
    }

    public void removerDisciplina(Disciplina d) {
        repo.delete(d.getId());
    }

}
