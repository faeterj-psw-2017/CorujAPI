package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.service.DesempenhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class DesempenhoController {

	private DesempenhoService service;

	@Autowired
	public DesempenhoController (DesempenhoService injected) {
		service = injected;
	}
	
	// ===============================================================

	@GetMapping("/desempenho")
	public List<Desempenho> listar ( ) {
		return service.listar ( );
	}
	
	@GetMapping("/desempenho/{id}")
	public Desempenho obter (@PathVariable long id) {
		return service.obter (id);
	}
	
	// ----------------------------------------------------------------
	
	@GetMapping(value="/desempenho/turma/{id}")
	public List<Desempenho> notas (@PathVariable long id) {
		return service.notas (id);
	}
	
	@GetMapping(value="/desempenho/aluno/{id}")
	public List<Desempenho> historico (@PathVariable long id) {
		return service.historico (id);
	}

	// ---------------------------------------------------------

	@GetMapping(value="/desempenho/turma/{id}/media")
	public double mediaNotas (@PathVariable long id) {
		return service.mediaNotas (id);
	}
	
	@GetMapping(value="/desempenho/aluno/{id}/media")
	public double mediaHistorico (@PathVariable long id) {
		return service.mediaHistorico (id);
	}

	@GetMapping(value="/desempenho/turma/{id}/media-final")
	public double mediaFinalNotas (@PathVariable long id) {
		return service.mediaFinalNotas (id);
	}
	
	@GetMapping(value="/desempenho/aluno/{id}/media-final")
	public double mediaFinalHistorico (@PathVariable long id) {
		return service.mediaFinalHistorico (id);
	}
	
	// ---------------------------------------------------------------
	
	@DeleteMapping(value="/desempenho/{id}")
	public Desempenho apagar (@PathVariable long id) {
		return service.apagar (id);
	}

	// --------------------------------------------------------------

	@PutMapping(value="/desempenho/{id}/AV1/{nota}")
	public boolean alterarAv1 (
		@PathVariable long   id,
		@PathVariable double nota
	) {
		return service.alterarAv1 (nota, id);
	}

	// --------------------------------------------------------------

	@PutMapping(value="/desempenho/{id}/AV2/{nota}")
	public boolean alterarAv2 (
		@PathVariable long id,
		@PathVariable double nota
	) {
		return service.alterarAv2 (nota, id);
	}

	// --------------------------------------------------------------

	@PutMapping(value="/desempenho/{id}/AVS/{nota}")
	public boolean alterarAvs (
		@PathVariable long   id,
		@PathVariable double nota
	) {
		return service.alterarAvs (nota, id);
	}

	// --------------------------------------------------------------

	@PutMapping(value="/desempenho/{id}/AVF/{nota}")
	public boolean alterarAvf (
		@PathVariable long   id,
		@PathVariable double nota
	) {
		return service.alterarAvf (nota, id);
	}

}

// OK