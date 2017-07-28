package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    /*

    // antiga interface pra adicionar aluno
    @RequestMapping(value="/aluno", method=RequestMethod.POST)
    public Aluno adicionarAluno (@RequestBody AlunoRequestBody requestBody) {
        return alunosService.adicionarAluno (requestBody.getNome ( ), requestBody.getMatricula ( ));
    }

     */

    // nova interface pra adicionar aluno, agora com todos os dados possiveis
    @RequestMapping(value="/aluno", method=RequestMethod.POST)
    public boolean adicionarAluno (@RequestBody AlunoRequestBody requestBody) {
    	Aluno aluno = new Aluno (requestBody);

        if (aluno.getNome ( )      != null &&
            aluno.getMatricula ( ) != null &&
            aluno.getEndereco ( )  != null &&
            aluno.getTelefone ( )  != null) {

            alunoService.salvarAluno (aluno);
            return true;
        }

        return false;
    }

    // aluno nunca é apagado do banco
    @RequestMapping(value="/aluno/{matricula}", method=RequestMethod.DELETE)
    public boolean removerAluno (@PathVariable String matricula) {
        return false;
    }

    @RequestMapping(value="/aluno/{matricula}", method=RequestMethod.GET)
    public Aluno obterAlunoPorMatricula (@PathVariable String matricula) {
    	return alunoService.obterAlunoPorMatricula (matricula);
    }
    
    @RequestMapping(value="/aluno", method=RequestMethod.PUT)
    public Aluno alterarAlunoPorMatricula (@RequestBody AlunoRequestBody requestBody) {
    	Aluno aluno = alunoService.obterAlunoPorMatricula (requestBody.getMatricula ( ));

    	if(null != aluno) {
    		aluno.setNome (requestBody.nome);
    		aluno.setEndereco (requestBody.endereco);
    		aluno.setSexo (requestBody.sexo);
    		aluno.setTelefone (requestBody.telefone);

    		alunoService.alterarAlunoPorMatricula (aluno);
    	}

    	return aluno;
    }

}

// OK