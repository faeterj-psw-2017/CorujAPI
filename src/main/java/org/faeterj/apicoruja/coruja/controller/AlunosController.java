package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

//    @RequestMapping(value="/aluno", method = RequestMethod.POST)
//    public Aluno adicionarAluno(@RequestBody AlunoRequestBody requestBody) {
//        return alunosService.adicionarAluno(requestBody.getNome(), requestBody.getMatricula());
//    }

//    @RequestMapping(value="/aluno/{matricula}", method = RequestMethod.DELETE)
//    public void removerAlunoPorMatricula(@PathVariable String matricula) {
//    	
//    }
    @RequestMapping(value="/aluno/salvar", method = RequestMethod.POST)
    public Aluno criarAluno(@RequestBody AlunoRequestBody requestBody){
    	Aluno aluno = new Aluno();
    	aluno.setEndereco(requestBody.endereco);
    	aluno.setNome(requestBody.nome);
    	aluno.setTelefone(requestBody.telefone);
    	aluno.setSexo(requestBody.sexo);
    	aluno.setMatricula(requestBody.matricula);
    	alunosService.salvarAluno(aluno);
    	return aluno;
    }
    
    @RequestMapping(value="/aluno/alterar", method = RequestMethod.POST)
    public Aluno alterarAlunoPorMatricula(@RequestBody AlunoRequestBody requestBody) {
    	Aluno aluno = alunosService.obterAlunoPorMatricula(requestBody.getMatricula());
    	if(null != aluno){
    		aluno.setNome(requestBody.nome);
    		aluno.setEndereco(requestBody.endereco);
    		aluno.setSexo(requestBody.sexo);
    		aluno.setTelefone(requestBody.telefone);
    		alunosService.alterarAlunoPorMatricula(aluno);
    	}
    	return aluno;
    }

    @RequestMapping(value="/aluno/{matricula}", method = RequestMethod.GET)
    public Aluno obterAlunoPorMatricula(@PathVariable String matricula) {
    	return alunosService.obterAlunoPorMatricula(matricula);
    }

}
