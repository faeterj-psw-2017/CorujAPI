package org.faeterj.apicoruja.coruja.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
@Service
public class AlunosService {

    private List<Aluno> alunos;
    private AlunoRepository alunoRepo;
    
    @Autowired
    public AlunosService(AlunoRepository alunoRepo){
    	this.alunoRepo = alunoRepo;
    }

    public Aluno obterAlunoPorMatricula(String matricula){
    	return alunoRepo.findByMatricula(matricula);
    }
    
    public void alterarAlunoPorMatricula(Aluno aluno){
    	alunoRepo.save(aluno);
    }
    
    public void salvarAluno(Aluno aluno){
    	alunoRepo.save(aluno);
    }

	public List<Aluno> obterAlunosPorNome(String nome) {
		return alunoRepo.findByNomeIgnoreCaseContaining(nome);
	}

}
