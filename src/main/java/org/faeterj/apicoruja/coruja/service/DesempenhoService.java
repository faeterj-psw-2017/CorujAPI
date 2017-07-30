package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;
import org.faeterj.apicoruja.coruja.model.repository.DesempenhoRepository;
import org.faeterj.apicoruja.coruja.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class DesempenhoService {

	private static double normalizar (double nota) {
		return Math.max(Math.min (nota, 0.0), 10.0);
	}
	
	private static double media (List<Desempenho> ds) {
		double x = 0.0;

		for (Desempenho d : ds) {
			x += d.media ( );
		}

		return x / ds.size ( );
	}

	private static double mediaFinal (List<Desempenho> ds) {
		double x = 0.0;

		for (Desempenho d : ds) {
			x += d.mediaFinal ( );
		}

		return x / ds.size ( );
	}
	
	// -------------------------------------------------------
	
	private DesempenhoRepository repository;
	private AlunoRepository      alunoRepo;
	private TurmaRepository      turmaRepo;
		
	@Autowired
	public DesempenhoService (
        DesempenhoRepository injected,
        AlunoRepository      injectedAlunoRepo,
        TurmaRepository      injectedTurmaRepo
    ) {
		repository = injected;
		alunoRepo  = injectedAlunoRepo;
		turmaRepo  = injectedTurmaRepo;
	}
	
    @PostConstruct
    public void init ( ) {
    	BootMessage.log (this);
    }
	
    // ================================================================
    
	public List<Desempenho> historico (long alunoId) {
		Aluno aluno = alunoRepo.findOne (alunoId);

        return repository.findByAluno (aluno);
	}
	
	public List<Desempenho> notas (long turmaId) {
		Turma turma = turmaRepo.findOne (turmaId);
		
		return repository.findByTurma (turma);
	}

	// ------------------------------------------------
	
	public double mediaHistorico (long alunoId) {
		return media (historico (alunoId));
	}

	public double mediaFinalHistorico (long alunoId) {
		return mediaFinal (historico (alunoId));
	}
	
	public double mediaNotas (long turmaId) {
		return media (notas (turmaId));
	}
	
	public double mediaFinalNotas (long turmaId) {
		return mediaFinal (notas (turmaId));
	}
	
	// ----------------------------------------------------------------
	
	@Transactional
	public Desempenho apagar (long id) {
		Desempenho d = repository.findOne (id);

		repository.delete(id);
		return d;
	}

	@Transactional
	public void criar (Desempenho d) {
		repository.save (d);
	}
	
	// ----------------------------------------------------
	
	@Transactional
	public boolean alterarAv1 (double av1, long id) {
		Desempenho d = repository.findOne (id);

		if (d == null) {
			return false;
		}

		d.setNotaAv1 (normalizar (av1));
		return true;
	}

	@Transactional
	public boolean alterarAv2 (double av2, long id) {
		Desempenho d = repository.findOne (id);

		if (d == null) {
			return false;
		}

		d.setNotaAv2 (normalizar (av2));
		return true;		
	}

	@Transactional
	public boolean alterarAvs (double avs, long id) {
		Desempenho d = repository.findOne (id);

		if (d == null) {
			return false;
		}

		d.setNotaAvs (normalizar (avs));
		return true;
	}

	@Transactional
	public boolean alterarAvf (double avf, long id) {
		Desempenho d = repository.findOne (id);
	
		if (d == null) {
			return false;
		}
	
		d.setNotaAvf (normalizar (avf));
		return true;
	}

	// -------------------------------------------------------------

	@Transactional
	public boolean alterarSegundaChamada (boolean flag, long id) {
		Desempenho d = repository.findOne(id);

		if (d == null) {
			return false;
		}

		d.setSegundaChamada (flag);
		return true;
	}

	// ----------------------------------------------------------------

	@Transactional
	public boolean alterarRecuperacao (boolean flag, long id) {
		Desempenho d = repository.findOne(id);

		if (d == null) {
			return false;
		}

		d.setRecuperacao (flag);
		return true;
	}

	// -------------------------------------------------------------------

	public List<Desempenho> listar ( ) {
		Iterable<Desempenho> it   = repository.findAll ( );
		List<Desempenho>     list = new ArrayList<> ( );

		for (Desempenho d : it) {
			list.add (d);
		}

		return list;
	}

	public Desempenho obter (long id) {
		return repository.findOne (id);
	}

}

// OK