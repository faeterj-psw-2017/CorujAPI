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
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class TrabalhoController {
	
	private TrabalhoService trabalhoService;
	private Trabalho trabalho;
	
	@RequestMapping(value="/trabalho", method=RequestMethod.GET)
	public List<Trabalho> listarTrabalho ( ) {
		return trabalhoService.listarTrabalhos();
	}
	@RequestMapping(value="/trabalho", method=RequestMethod.POST)
    public boolean salvaTrabalho (@RequestBody TrabalhoRequestBody requestBody) {

		trabalho.setAluno(requestBody.getAluno());
        trabalho.setTitulo(requestBody.getTitulo());
        trabalho.setTurma(requestBody.getTurma());
        trabalho.setId((long)this.listarTrabalho().size()+1);
        if (trabalho.getAluno() != null &&
            trabalho.getTitulo() != null &&
            trabalho.getTurma()  != null &&
            trabalho.getId()  != null) 
        	{
    	    trabalhoService.salvarTrabalho(trabalho);
    	    return true;
        	}
        return false;
    }
	
	@RequestMapping(value="/trabalho", method=RequestMethod.PUT)
	public boolean editar(@RequestBody TrabalhoRequestBody requestBody) {
		trabalho = trabalhoService.encontrarTrabalhoPeloId(requestBody.getId());
	   
	    if (trabalho!=null)
	    {
		if(requestBody.getTitulo()!=null && !trabalho.getTitulo().equals(requestBody.getTitulo())){
			trabalho.setTitulo(requestBody.getTitulo());
			}
		trabalhoService.salvarTrabalho(trabalho);
		return true;
		    }
	    return false;
	}
	
	
}
