package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.TurmaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.entity.TurmaAlunoNotas;
import org.faeterj.apicoruja.coruja.service.AlunosService;
import org.faeterj.apicoruja.coruja.service.ProfessorService;
import org.faeterj.apicoruja.coruja.service.TurmaAlunoNotasService;
import org.faeterj.apicoruja.coruja.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	private ProfessorService professorService;
    private TurmaService turmaService;
    private AlunosService alunoService;
    private TurmaAlunoNotasService alunoTurmaService;

    @Autowired
    public TurmaController(TurmaService turmaService, ProfessorService professorService, AlunosService alunoService, TurmaAlunoNotasService alunoTurmaService) {
        this.turmaService = turmaService;
        this.professorService=professorService;
        this.alunoService=alunoService;
        this.alunoTurmaService=alunoTurmaService;
    }

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public List<Turma> listarTurma() {
        return turmaService.obterTurmas();
    }

    @RequestMapping(value="/salvar", method = RequestMethod.POST)
    public boolean adicionarTurma(@RequestBody TurmaRequestBody requestBody) {
        Turma turma;
        if(requestBody.getCodigo()!=null &&  requestBody.getSala()!=null && requestBody.getTurno()!=null){
        	turma= new Turma(requestBody.getCodigo(), requestBody.getSala(), requestBody.getTurno());
        	turmaService.salvarTurma(turma);
        	return true;
        }
    	return false;
    }
    
    @RequestMapping(value="/adicionar_professor", method = RequestMethod.POST)
    public boolean adicionarProfessor(@RequestBody TurmaRequestBody turmaRequestBody){
    	Professor professor=professorService.encontrarProfessorPelaMatricula(turmaRequestBody.getMatricula());
       	if(professor!=null && turmaRequestBody.getCodigo()!=null){
       		return turmaService.adicionaProfessor(turmaRequestBody.getCodigo(), professor);
       	}
       	return false;
   	}
    
    @RequestMapping(value="/remover_professor", method = RequestMethod.POST)
    public boolean removerProfessor(@RequestBody TurmaRequestBody turmaRequestBody){
    	Professor professor=professorService.encontrarProfessorPelaMatricula(turmaRequestBody.getMatricula());
       	if(professor!=null && turmaRequestBody.getCodigo()!=null){
       		return turmaService.removerProfessor(turmaRequestBody.getCodigo(), professor);
       	}
       	return false;
   	}
    
    @RequestMapping(value="/remover_turma", method = RequestMethod.POST)
    public void removerTurma(@RequestBody TurmaRequestBody turmaRequestBody) {
    	Turma turma = turmaService.obterTurma(turmaRequestBody.getCodigo());
    	turmaService.excluirTurma(turma);
    }

    @RequestMapping(value="/adicionar_aluno", method = RequestMethod.POST)
    public boolean adicionarAluno(@RequestBody TurmaRequestBody turmaRequestBody){
    	Aluno aluno=alunoService.encontrarAlunoPelaMatricula(turmaRequestBody.getMatricula());
       	if(aluno!=null && turmaRequestBody.getCodigo()!=null){
       		return turmaService.adicionaAluno(turmaRequestBody.getCodigo(), aluno);
       	}
       	return false;
   	}
    @RequestMapping(value="/adiciona_av1", method = RequestMethod.POST)
    public boolean adicionarAv1(@RequestBody TurmaRequestBody turmaRequestBody){
    	Aluno aluno=alunoService.encontrarAlunoPelaMatricula(turmaRequestBody.getMatricula());
    	Turma turma = turmaService.obterTurma(turmaRequestBody.getCodigo());
    	TurmaAlunoNotas alunoTurma;
    	if(aluno!=null && turma!=null && turmaRequestBody.getNota()!=null){
    		alunoTurma=alunoTurmaService.encontrarTurmaAlunoNotasPeloAluno(aluno);
    		if(alunoTurma!=null){
    			return turmaService.lancarNotaAv1(turma, alunoTurma, turmaRequestBody.getNota());
    		}
    		return false;
    	}
    	return false;
    }
    
    @RequestMapping(value="/adiciona_av2", method = RequestMethod.POST)
    public boolean adicionarAv2(@RequestBody TurmaRequestBody turmaRequestBody){
    	Aluno aluno=alunoService.encontrarAlunoPelaMatricula(turmaRequestBody.getMatricula());
    	Turma turma = turmaService.obterTurma(turmaRequestBody.getCodigo());
    	TurmaAlunoNotas alunoTurma;
    	if(aluno!=null && turma!=null && turmaRequestBody.getNota()!=null){
    		alunoTurma=alunoTurmaService.encontrarTurmaAlunoNotasPeloAluno(aluno);
    		if(alunoTurma!=null){
    			return turmaService.lancarNotaAv2(turma, alunoTurma, turmaRequestBody.getNota());
    		}
    		return false;
    	}
    	return false;
    }
    
    @RequestMapping(value="/adiciona_avf", method = RequestMethod.POST)
    public boolean adicionarAvf(@RequestBody TurmaRequestBody turmaRequestBody){
    	Aluno aluno=alunoService.encontrarAlunoPelaMatricula(turmaRequestBody.getMatricula());
    	Turma turma = turmaService.obterTurma(turmaRequestBody.getCodigo());
    	TurmaAlunoNotas alunoTurma;
    	if(aluno!=null && turma!=null && turmaRequestBody.getNota()!=null){
    		alunoTurma=alunoTurmaService.encontrarTurmaAlunoNotasPeloAluno(aluno);
    		if(alunoTurma!=null){
    			return turmaService.lancarNotaAvf(turma, alunoTurma, turmaRequestBody.getNota());
    		}
    		return false;
    	}
    	return false;
    }

}
