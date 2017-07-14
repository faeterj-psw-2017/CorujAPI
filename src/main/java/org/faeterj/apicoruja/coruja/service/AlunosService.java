package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
@Service
public class AlunosService {

    private List<Aluno> alunos;

    @PostConstruct
    public void init() {
        System.out.println("Criado modelo de alunos");
        Aluno a = new Aluno();
        a.setId(1L);
        a.setMatricula("11");
        a.setNome("João");

        alunos = new ArrayList<Aluno>();
        alunos.add(a);
    }

    public List<Aluno> obterAlunos() {

        return alunos;

    }

    public Aluno adicionarAluno(String nome, String matricula) {
        long id = 0L;
        for (Aluno a : alunos) {
            if (a.getId() > id) {
                id = a.getId();
            }
        }
        id++;
        Aluno a = new Aluno();
        a.setId(id);
        a.setNome(nome);
        a.setMatricula(matricula);
        alunos.add(a);
        return a;
    }

}
