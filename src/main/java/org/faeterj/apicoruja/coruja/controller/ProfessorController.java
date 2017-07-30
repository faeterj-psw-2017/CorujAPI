package org.faeterj.apicoruja.coruja.controller;


import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.ProfessorRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProfessorController {

    private ProfessorService service;

    @Autowired
    public ProfessorController (ProfessorService service) {
    	this.service = service;
    }
    
    // -------------------------------------------------------------------------------
    
    @GetMapping(value="/professor")
    public List<Professor> listar ( ) {
        return service.listar ( );
    }

    @PostMapping(value="/professor")
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

    @GetMapping(value="/professor/matricula/{matricula}")
    public Professor obter (@PathVariable String matricula) {
    	return service.encontrarPorMatricula (matricula);
    }

    @DeleteMapping(value="/professor/matricula/{matricula}")
    public boolean excluir (@PathVariable String matricula) {
    	return service.excluir (matricula);
    }

    // ---------------------------------------------------------------------------
    
    @PutMapping(value="/professor")
    public boolean editar (@RequestBody ProfessorRequestBody requestBody) {
    	return service.editar (
    		requestBody.matricula,
    		requestBody.nome,
    		requestBody.endereco,
    		requestBody.telefone
    	);
    }

    // ------------------------------------------------------------------------------

    @GetMapping(value="/professor/sexo/{sexo}")
    public List<Professor> procurarPorSexo (@PathVariable char sexo) {
    	return service.encontrarPorSexo (sexo);
    }

    @GetMapping(value="/professor/endereco/{endereco}")
    public List<Professor> procurarPorEndereco (@PathVariable String endereco) {
    	return service.encontrarPorEndereco (endereco);
    }

    // ---------------------------------------------------------------------

    @GetMapping("/professor/{id}")
    public Professor obter (@PathVariable long id) {
    	return service.obter (id);
    }
    
}

// OK