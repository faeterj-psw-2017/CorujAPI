package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.ProfessorRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * 
 *  Rota                   | Metodo | Corpo         | Resposta
 * =====================================================================
 * 	/professor             | GET    |               | [ professores... ]
 * 	/professor             | POST   | { professor } | boolean
 * 	/professor/matricula/X | GET    |               | { professor }
 *  /professor/matricula/X | DELETE |               | boolean
 *  /professor             | PUT    | { professor } | boolean
 *                 
 */
@RestController
public class ProfessorController {

    private ProfessorService service;

    @Autowired
    public ProfessorController (ProfessorService service) {
    	this.service = service;
    }
    
    // -------------------------------------------------------------------------------
    
    @RequestMapping(value="/professor", method=RequestMethod.GET)
    public List<Professor> listarProfessor ( ) {
        return service.listar ( );
    }

    @RequestMapping(value="/professor", method=RequestMethod.POST)
    public boolean salvar (@RequestBody ProfessorRequestBody requestBody) {
        Professor professor =
            service.encontrarPorMatricula (requestBody.matricula);
            
        if (professor != null) {
        	return false;
        }

        service.salvar (new Professor (requestBody));
        return true;
    }

    // -------------------------------------------------------------------------------------

    @RequestMapping(value="/professor/matricula/{matricula}", method=RequestMethod.GET)
    public Professor obter (@PathVariable String matricula) {
    	return service.encontrarPorMatricula (matricula);
    }

    @RequestMapping(value="/professor/matricula/{matricula}", method=RequestMethod.DELETE)
    public boolean excluir (@PathVariable String matricula) {
    	return service.excluir (matricula);
    }

    // ---------------------------------------------------------------------------
    
    @RequestMapping(value="/professor", method=RequestMethod.PUT)
    public boolean editar (@RequestBody ProfessorRequestBody requestBody) {
    	return service.editar (
    		requestBody.matricula,
    		requestBody.nome,
    		requestBody.endereco,
    		requestBody.telefone
    	);
    }

}

// OK