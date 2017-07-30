package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GradeController {

	private GradeService service;

	@Autowired
	public GradeController (GradeService service) {
		this.service = service;
	}
	
	// ===================================================================
	
	@RequestMapping (
		value  = { "/grade", "/grade/*" },
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