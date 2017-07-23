package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
@Service
public class AlunosService {
	
	private AlunoRepository alunoRepositorio;
	
	@Autowired
	public void setAlunoRepository(AlunoRepository alunoRepositorio){
		this.alunoRepositorio=alunoRepositorio;
	}
	
	public void salvarAluno(Aluno aluno){
		alunoRepositorio.save(aluno);
	}
	
	public List<Aluno> listarAlunos(){
		return (List<Aluno>) alunoRepositorio.findAll();
	}
	
	public Aluno encontrarAlunoPelaMatricula(String matricula){
		return alunoRepositorio.findByMatricula(matricula);
	}

}
