package org.faeterj.apicoruja.coruja.service;

import java.util.List;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public final class ProfessorService {

	private ProfessorRepository professorRepositorio;
	private TurmaService        turmaService;
	
	@Autowired
	public void setProfessorRepository (
        ProfessorRepository professorRepositorio,
        TurmaService        turmaService
    ) {
        this.professorRepositorio = professorRepositorio;
        this.turmaService         = turmaService;
	}

    @PostConstruct
    public void init ( ) {
    	BootMessage.log (this);
    }

	public void salvarProfessor (Professor professor) {
        professorRepositorio.save (professor);
	}
	
	public List<Professor> listarProfessores ( ) {
        return (List<Professor>) professorRepositorio.findAll ( );
	}
	
	public void excluirProfessor (Long id){
        Professor prof = professorRepositorio.findOne (id);

        professorRepositorio.delete (prof);
	}
	
	public Professor encontrarProfessorPelaMatricula (String matricula) {
        return professorRepositorio.findByMatricula (matricula);
	}
	
	public List<Professor> encontrarProfessorPeloEndereco (String endereco) {
        return professorRepositorio.findByEndereco (endereco);
	}
	
	public List<Professor> encontrarProfessorPeloNome (String nome) {
        return professorRepositorio.findByNome (nome);
	}
	
	public List<Professor> encontrarProfessorPeloTelefone(String telefone){
        return professorRepositorio.findByNome(telefone);
	}
	
	public Professor encontrarProfessorPeloId (Long id) {
        return professorRepositorio.findOne (id);
	}
	
	public Professor encontrarProfessorPelaTurma (String codigoTurma) {
        Turma turma = turmaService.obterTurma (codigoTurma);
        Professor professor;

        if (turma == null) {
            return null;
        }

        if (turma.getProfessor ( ) != null) {
            professor = turma.getProfessor ( );
            return professor;
        }

        return null;
	}

}
