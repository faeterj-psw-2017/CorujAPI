package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import java.util.ArrayList;
import java.util.List;
import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class TrabalhoService {
	
	private TrabalhoRepository repo;

	@Autowired
	public TrabalhoService (TrabalhoRepository trabalhoRepositorio) {
		this.repo = trabalhoRepositorio;
	}

	@PostConstruct
	void init ( ) {
		BootMessage.log (this);
	}

	// ============================================================
	
	public void salvarTrabalho (Trabalho trabalho) {
		repo.save (trabalho);
	}

	public List<Trabalho> listar ( ) {
        Iterable<Trabalho> iterable = repo.findAll ( );
        List<Trabalho> trabalhos    = new ArrayList<Trabalho> ( );

        for (Trabalho trabalho : iterable) {
        	trabalhos.add (trabalho);
        }
        
        return trabalhos;
	}

	// -------------------------------------------------------------------
	
	public List<Trabalho>  encontrarTrabalhoPeloTitulo (String titulo) {
		return repo.findByTitulo (titulo);
	}

	public List<Trabalho>  encontrarTrabalhoPeloAluno (Aluno aluno) {
		return repo.findByAluno (aluno);
	}

	public List<Trabalho> encontrarTrabalhoPelaTurma (Turma turma) {
		return repo.findByTurma (turma);
	}

	// -----------------------------------------------------------------
	
	public Trabalho encontrar (String titulo, Aluno aluno, Turma turma) {
		return repo.findByTituloAndAlunoAndTurma (titulo, aluno, turma);
	}

	// retorna o mesmo trabalho, só que com o ID do
	// banco acompanhado no retorno, só pra modificar
	public Trabalho encontrar (Trabalho busca) {
		return encontrar (busca.getTitulo ( ), busca.getAluno ( ), busca.getTurma ( ));
	}

	// ----------------------------------------------------------------------

	public boolean apagar (Trabalho busca) {
		Trabalho trabalho = this.encontrar (busca);

		if (trabalho == null) {
			return false;
		}
		
		repo.delete (trabalho.getId ( ));
		return true;
	}

}

// OK