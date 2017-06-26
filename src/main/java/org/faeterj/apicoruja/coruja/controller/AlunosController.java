package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */

@RestController
public class AlunosController {

    private AlunosService alunosService;

    @Autowired
    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @RequestMapping(value="/alunos", method = RequestMethod.GET)
    public List<Aluno> listarAlunos() {
        return alunosService.obterAlunos();
    }

    @RequestMapping(value="/alunos", method = RequestMethod.POST)
    public Aluno adicionarAluno(@RequestBody AlunoRequestBody requestBody) {
        return alunosService.adicionarAluno(requestBody.getNome(), requestBody.getMatricula());
    }

    public void removerAluno() {

    }

    public void obterAluno() {

    }

}
