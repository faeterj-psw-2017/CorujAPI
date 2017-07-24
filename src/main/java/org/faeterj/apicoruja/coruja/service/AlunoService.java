package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	private AlunoRepository alunoRepositorio;

    @Autowired
    public AlunoService (AlunoRepository alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

	@PostConstruct
	public void init ( ) {

    }
	
	public void salvarAluno (Aluno aluno) {
        alunoRepositorio.save (aluno);
	}
	
	public List<Aluno> listarAlunos ( ) {
        return (List<Aluno>) alunoRepositorio.findAll ( );
	}
	
	public Aluno encontrarAlunoPelaMatricula (String matricula) {
        return alunoRepositorio.findByMatricula (matricula);
	}

}
