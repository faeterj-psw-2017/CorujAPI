package org.faeterj.apicoruja.coruja.controller;

import java.util.List;
import org.faeterj.apicoruja.coruja.controller.requestBody.ProfessorRequestBody;
import org.faeterj.apicoruja.coruja.controller.requestBody.TrabalhoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TrabalhoController {
	
	private TrabalhoService service;

	@Autowired
	public TrabalhoController (TrabalhoService service) {
		this.service = service;
	}
	
	// ================================================================
	
	@GetMapping(value="/trabalho")
	public List<Trabalho> listarTrabalho ( ) {
		return service.listar ( );
	}

	@PostMapping(value="/trabalho")
    public boolean salvaTrabalho (@RequestBody TrabalhoRequestBody body) {
		Trabalho trabalho = new Trabalho (body);

        if (
        	trabalho.getAluno  ( ) != null &&
            trabalho.getTitulo ( ) != null &&
            trabalho.getTurma  ( ) != null
        ) {
    	    service.salvarTrabalho (trabalho);
    	    return true;
        }

        return false;
    }
	
	// ---------------------------------------------------------
	
	@PutMapping(value="/trabalho")
	public boolean editar (@RequestBody TrabalhoRequestBody body) {
		Trabalho busca    = new Trabalho (body);
		Trabalho trabalho = service.encontrar (busca);
	   
	    if (trabalho != null) {
	    	if (
	    		body.titulo != null &&
	    		!trabalho.getTitulo ( ).equals (body.titulo)
	    	) {
	    		trabalho.setTitulo (body.titulo);
			}

			service.salvarTrabalho (trabalho);
			return true;
		}

	    return false;
	}

	@DeleteMapping(value="/trabalho")
	public boolean apagar (@RequestBody TrabalhoRequestBody body) {
		return service.apagar (new Trabalho (body));
	}

}

// OK