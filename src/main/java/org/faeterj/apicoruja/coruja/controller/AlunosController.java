package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */

@RestController
@RequestMapping("/aluno")
public class AlunosController {

    private AlunosService alunosService;

    @Autowired
    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public List<Aluno> listarAlunos() {
        return alunosService.listarAlunos();
    }

    @RequestMapping(value="/salvar", method = RequestMethod.POST)
    public boolean adicionarAluno(@RequestBody AlunoRequestBody requestBody) {
        
    	 Aluno aluno = new Aluno();
    	 aluno.setNome(requestBody.getNome());
    	 aluno.setMatricula(requestBody.getMatricula());
    	 aluno.setEndereco(requestBody.getEndereco());
    	 aluno.setTelefone(requestBody.getTelefone());
         if(aluno.getNome()!=null && aluno.getMatricula()!=null && aluno.getEndereco()!=null && aluno.getTelefone()!=null){
      	   alunosService.salvarAluno(aluno);
      	   return true;
         }
         return false;
    }

    public void removerAluno() {

    }

    public void obterAluno() {

    }

}
