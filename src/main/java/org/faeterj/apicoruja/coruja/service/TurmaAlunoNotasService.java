package org.faeterj.apicoruja.coruja.service;


import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.TurmaAlunoNotas;
import org.faeterj.apicoruja.coruja.model.repository.TurmaAlunoNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaAlunoNotasService{
	
	
	private TurmaAlunoNotasRepository turmaAlunoNotasRepositorio;
	
	
	@Autowired
	public void setTurmaAlunoNotasRepositorio(TurmaAlunoNotasRepository turmaAlunoNotasRepositorio){
		this.turmaAlunoNotasRepositorio=turmaAlunoNotasRepositorio;
	}
	
	
	public TurmaAlunoNotas encontrarTurmaAlunoNotasPeloAluno(Aluno aluno){
		 return turmaAlunoNotasRepositorio.findByIdAluno(aluno);
	}
	
	/*public TurmaAlunoNotas encontrarTurmaAlunoNotasPelaTurma(Turma turma){
		return turmaAlunoNotasRepositorio.findByIdTurma(turma.getId());
	}*/

}
