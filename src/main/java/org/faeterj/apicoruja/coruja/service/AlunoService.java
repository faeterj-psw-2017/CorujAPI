package org.faeterj.apicoruja.coruja.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
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
        BootMessage.log (this);
    }
	
    public void alterarAlunoPorMatricula (Aluno aluno) {
    	alunoRepositorio.save (aluno);
    }
	
    // TODO
    // remover futuramente devido a compatibilidade agora?
	public void salvarAluno (Aluno aluno) {
        this.alterarAlunoPorMatricula (aluno);
	}
	
	// TODO
	// otimizar isso com uma Stream por demanda ao invés
	// de uma lista com uma p*rrada de alunos
	public List<Aluno> listarAlunos ( ) {
        List<Aluno> alunos = new ArrayList<Aluno> ( );

        Iterable<Aluno> iterable = alunoRepositorio.findAll ( );

        for (Aluno aluno : iterable) {
        	alunos.add (aluno);
        }
        
        return alunos;
	}

	// TODO
	// apagar metodo que esta
	// mantendo compatibilidade com antiga interface
    public List<Aluno> obterAlunos ( ) {
        return this.listarAlunos ( );
    }

	/*

	// antiga interface pra adicionar aluno
    public Aluno adicionarAluno (String nome, String matricula) {
        Aluno aluno = new Aluno ( );

        aluno.setNome (nome);
        aluno.setMatricula (matricula);

        alunoRepositorio.save (aluno);

        return aluno;
    }
    
    */

	public Aluno encontrarAlunoPelaMatricula (String matricula) {
        return alunoRepositorio.findByMatricula (matricula);
	}
    
	// TODO
	// remover depois tal metodo
    public Aluno obterAlunoPorMatricula (String matricula) {
    	return this.encontrarAlunoPelaMatricula (matricula);
    }

}

// OK