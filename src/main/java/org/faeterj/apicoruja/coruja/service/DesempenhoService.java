package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.model.repository.DesempenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class DesempenhoService {

	private DesempenhoRepository desempenhoRepositorio;
		
	@Autowired
	public DesempenhoService (
        DesempenhoRepository desempenhoRepositorio
    ) {
		this.desempenhoRepositorio = desempenhoRepositorio;
	}
	
    @PostConstruct
    public void init ( ) {
    	BootMessage.log (this);
    }
	
	public Desempenho encontrarTurmaAlunoNotasPeloAluno (Aluno aluno) {
        return desempenhoRepositorio.findOne (aluno.getId ( ));
	}
	
}
