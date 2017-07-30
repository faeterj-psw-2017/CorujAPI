package org.faeterj.apicoruja.coruja.service;

import javax.annotation.PostConstruct;

import org.faeterj.apicoruja.coruja.log.BootMessage;
import org.faeterj.apicoruja.coruja.model.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class GradeService {

	private GradeRepository repo;
	
	@PostConstruct
	public void init ( ) {
		BootMessage.log (this);
	}

	@Autowired
	public GradeService (GradeRepository repo) {
		this.repo = repo;
	}
	
}

// OK