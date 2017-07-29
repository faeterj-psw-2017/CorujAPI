package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Historico;
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

    // ---------------------------------------------------
    // aluno nunca é apagado do banco
    // ---------------------------------------------------


    @RequestMapping(value="/aluno/{matricula}", method=RequestMethod.GET)
    public Aluno obterAlunoPorMatricula (@PathVariable String matricula) {
    	return alunoService.obterAlunoPorMatricula (matricula);
    }
    
    // matricula nunca pode ser mudada, assim como o rg e cpf
    @RequestMapping(value="/aluno", method=RequestMethod.PUT)
    public Aluno alterarAlunoPorMatricula (@RequestBody AlunoRequestBody requestBody) {
    	Aluno aluno = alunoService.obterAlunoPorMatricula (requestBody.matricula);

    	if (null != aluno) {
    		aluno.setNome (requestBody.nome);
    		aluno.setEndereco (requestBody.endereco);
    		aluno.setSexo (requestBody.sexo);
    		aluno.setTelefone (requestBody.telefone);

    		if (requestBody.historico != null) {
    			aluno.setHistorico (new Historico (requestBody.historico));
    		}

    		alunoService.alterarAlunoPorMatricula (aluno);
    	}

    	return aluno;
    }

}

// OK