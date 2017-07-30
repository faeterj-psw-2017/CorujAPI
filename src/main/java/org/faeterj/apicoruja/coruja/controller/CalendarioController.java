package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CalendarioController {

	private CalendarioService service;

	@Autowired
	public CalendarioController (CalendarioService service) {
		this.service = service;
	}
	
	// =================================================================

	@RequestMapping (
		value  = { "/calendario", "/calendario/*" },
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