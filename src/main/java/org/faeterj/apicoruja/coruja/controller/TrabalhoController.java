package org.faeterj.apicoruja.coruja.controller;
import org.faeterj.apicoruja.coruja.controller.requestBody.TrabalhoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

public class TrabalhoController {
	
	private TrabalhoService trabalhoService;
	private Aluno aluno;
	private Turma turma;
	private Trabalho trabalho;
	
	TrabalhoRequestBody trabalhoRequestBody;
}
