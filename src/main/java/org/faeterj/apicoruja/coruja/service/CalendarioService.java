package org.faeterj.apicoruja.coruja.service;

import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CalendarioService {

	private CalendarioRepository repository;

	@PostConstruct
	public void init ( ) {
		BootMessage.log (this);
	}
	
	@Autowired
	public CalendarioService (CalendarioRepository repository) {
		this.repository = repository;
	}

}

// OK