package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
@Service
public class ProfessorService{
	
	
	private ProfessorRepository professorRepositorio;
	
	@Autowired
	public void setProfessorRepository(ProfessorRepository professorRepositorio){
		this.professorRepositorio=professorRepositorio;
	}
	
	public void salvarProfessor(Professor professor){
		professorRepositorio.save(professor);
	}
	
	public List<Professor> listarProfessores(){
		return (List<Professor>) professorRepositorio.findAll();
	}
	
	public Professor encontrarProfessorPelaMatricula(String matricula){
		return professorRepositorio.findByMatricula(matricula);
	}
	
	public void excluirProfessor(long id){
		professorRepositorio.delete(id);
	}

}
