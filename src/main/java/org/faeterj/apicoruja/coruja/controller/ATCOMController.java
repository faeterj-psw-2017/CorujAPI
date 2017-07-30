package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.ATCOMRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.service.ATCOMService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ATCOMController {

    private ATCOMService service;

    @Autowired
    public ATCOMController (ATCOMService service) {
        this.service = service;
    }

    // =====================================================
    
    @PostMapping("/atcom")
    public ATCOM criar (@RequestBody ATCOMRequestBody body) {
        return service.criar (new ATCOM (body));
    }

    @PutMapping("/atcom/{id}")
    public ATCOM atualizar (
    	@RequestBody  ATCOMRequestBody body,
    	@PathVariable long id
    ) {
    	ATCOM atcom = new ATCOM (body);

        return service.atualizar (atcom, id);
    }

    // -----------------------------------------------------
    
    @DeleteMapping("/atcom/{id}")
    public ATCOM apagar (@PathVariable long id) {
    	ATCOM atcom = service.obter (id);

    	service.apagar (id);
    	return atcom;
    }

    @GetMapping ("/atcom")
    public List<ATCOM> listar ( ) {
    	return service.listar ( ); 
    }
    
    // -------------------------------------------------------------

    @GetMapping("/atcom/{id}")
    public ATCOM obter (@PathVariable long id) {
    	return service.obter (id);
    }

    @GetMapping("/atcom/valido")
    public List<ATCOM> validos ( ) {
    	return service.validos ( );
    }
    
    @GetMapping("/atcom/invalido")
    public List<ATCOM> invalidos ( ) {
    	return service.invalidos ( );
    }    
    
    // ---------------------------------------------------------------

    @GetMapping("/atcom/aluno/{id}")
    public List<ATCOM> aluno (@PathVariable long id) {
    	return service.aluno (id);
    }
    
    @GetMapping("/atcom/validados/{id}")
    public List<ATCOM> validados (@PathVariable long id) {
    	return service.validadosDoAluno (true, id);
    }

    @GetMapping("/atcom/invalidados/{id}")
    public List<ATCOM> invalidados (@PathVariable long id) {
    	return service.validadosDoAluno (false, id);
    }
    
}

// OK