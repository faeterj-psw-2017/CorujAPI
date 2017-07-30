package org.faeterj.apicoruja.coruja.service;

import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class HistoricoService {

	private HistoricoRepository repository;

	@Autowired
	public HistoricoService (HistoricoRepository repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void init ( ) {
		BootMessage.log (this);
	}
	
}

// OK