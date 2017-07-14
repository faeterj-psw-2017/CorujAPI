package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.professorRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
    private ProfessorService professorService;
	private Professor professor;

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public List<Professor> listarProfessor() {
        return professorService.listarProfessores();
    }

   @RequestMapping(value="/salvar", method = RequestMethod.POST)
    public boolean salvaProfessor(@RequestBody professorRequestBody requestBody){
       Professor professor = new Professor();
       professor.setNome(requestBody.getNome());
       professor.setMatricula(requestBody.getMatricula());
       professor.setEndereco(requestBody.getEndereco());
       professor.setTelefone(requestBody.getTelefone());
       if(professor.getNome()!=null && professor.getMatricula()!=null && professor.getEndereco()!=null && professor.getTelefone()!=null){
    	   professorService.salvarProfessor(professor);
    	   return true;
       }
       return false;
    }
   @RequestMapping(value="/excluir", method = RequestMethod.POST)
   public boolean excluirProfessor(@RequestBody professorRequestBody requestBody){
	   professor = professorService.encontrarProfessorPelaMatricula(requestBody.getMatricula());
	   if(professor!=null){
		   professorService.excluirProfessor(professor.getId());
		   return true;
	   }
	   return false;
   }
   
   @RequestMapping(value="/editar", method=RequestMethod.POST)
   public boolean editar(@RequestBody professorRequestBody requestBody){
	   professor = professorService.encontrarProfessorPelaMatricula(requestBody.getMatricula());
	   if(professor!=null){
		   if(requestBody.getNome()!=null && !professor.getNome().equals(requestBody.getNome())){
			   professor.setNome(requestBody.getNome());
		   }
		   
		   if(requestBody.getEndereco()!=null && !professor.getEndereco().equals(requestBody.getEndereco())){
			   professor.setEndereco(requestBody.getEndereco());
		   }
		   
		   if(requestBody.getTelefone()!=null && !professor.getTelefone().equals(requestBody.getTelefone())){
			   professor.setTelefone(requestBody.getTelefone());
		   }
		   
		   if(requestBody.getMatricula()!=null && !professor.getMatricula().equals(requestBody.getMatricula())){
			   professor.setMatricula(requestBody.getMatricula());
		   }
		   professorService.salvarProfessor(professor);
		   return true;
	   }
	   return false;
   }
}
