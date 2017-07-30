package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    private AlunoService service;

    @Autowired
    public AlunoController (AlunoService injected) {
        service = injected;
    } 
    
    // ===============================================================

    @PostMapping(value="/aluno")
    public boolean adicionar (@RequestBody AlunoRequestBody body) {
    	return service.adicionar (new Aluno (body));
    }

    @GetMapping("/aluno")
    public List<Aluno> listar ( ) {
    	return service.listar ( );
    }
 
    @GetMapping("/aluno/{id}")
    public Aluno obter (@PathVariable long id) {
    	return service.obter (id);
    }
    
    // -----------------------------------------------------------------

    @DeleteMapping(value="/aluno/matricula/{matricula}")
    public boolean apagarPorMatricula (@PathVariable String matricula) {
    	return service.apagarPorMatricula (matricula);
    }

    @DeleteMapping("/aluno/{id}")
    public boolean apagar (@PathVariable long id) {
    	return service.apagar (id);
    }
    
    @GetMapping(value="/aluno/matricula/{matricula}")
    public Aluno obterPorMatricula (@PathVariable String matricula) {
    	return service.obterPorMatricula (matricula);
    }

    // ------------------------------------------------------------------
    
    // matricula nunca pode ser mudada, assim como o rg e cpf
    @PutMapping(value="/aluno")
    public Aluno alterarPorMatricula (@RequestBody AlunoRequestBody body) {
    	return service.alterarPorMatricula (new Aluno (body));
    }

}

// OK