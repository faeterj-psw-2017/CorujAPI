package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HistoricoController {

	private HistoricoService service;

	@Autowired
	public HistoricoController (HistoricoService service) {
		this.service = service;
	}
	
	// ===================================================================
	
	@RequestMapping (
		value  = { "/historico", "/historico/*" },
		method = {
			RequestMethod.GET,
			RequestMethod.POST,
			RequestMethod.PUT,
			RequestMethod.DELETE
		} 
	)
	@ResponseBody
	public String naoImplementado ( ) {
		return "Tal rota não foi implementada!";
	}
	
}

// OK