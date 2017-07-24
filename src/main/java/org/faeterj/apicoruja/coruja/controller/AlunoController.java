package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController (AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @RequestMapping(value="/aluno", method=RequestMethod.GET)
    public List<Aluno> listarAlunos ( ) {
        return alunoService.listarAlunos ( );
    }

    @RequestMapping(value="/aluno", method=RequestMethod.POST)
    public boolean adicionarAluno(@RequestBody AlunoRequestBody requestBody) {
    	Aluno aluno = new Aluno ( );

    	aluno.setNome      (requestBody.getNome ( ));
    	aluno.setMatricula (requestBody.getMatricula ( ));
    	aluno.setEndereco  (requestBody.getEndereco ( ));
    	aluno.setTelefone  (requestBody.getTelefone ( ));
        aluno.setCpf       (requestBody.getCpf ( ));
        aluno.setRg        (requestBody.getRg ( ));

        if (aluno.getNome()!=null && aluno.getMatricula()!=null && aluno.getEndereco()!=null && aluno.getTelefone()!=null){
            alunoService.salvarAluno (aluno);
            return true;
        }

        return false;
    }

    // TODO
    @RequestMapping(value="/aluno/{matricula}", method=RequestMethod.DELETE)
    public boolean removerAluno (@PathVariable String matricula) {
        return false;
    }

    // TODO
    @RequestMapping(value="/aluno/{matricula}", method=RequestMethod.GET)
    public Aluno obterAluno (@PathVariable String matricula) {
        return null;
    }

}
