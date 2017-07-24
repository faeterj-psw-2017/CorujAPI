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

@RestController
public class ProfessorController {

    private ProfessorService professorService;
	private Professor professor;

    @RequestMapping(value="/professor", method=RequestMethod.GET)
    public List<Professor> listarProfessor ( ) {
        return professorService.listarProfessores ( );
    }

    @RequestMapping(value="/professor", method=RequestMethod.POST)
    public boolean salvaProfessor (@RequestBody ProfessorRequestBody requestBody) {
        Professor professor = new Professor ( );

        professor.setNome      (requestBody.getNome ( ));
        professor.setMatricula (requestBody.getMatricula ( ));
        professor.setEndereco  (requestBody.getEndereco ( ));
        professor.setTelefone  (requestBody.getTelefone ( ));
        professor.setRg        (requestBody.getRg ( ));
        professor.setCpf       (requestBody.getCpf ( ));

        if (professor.getNome ( )      != null &&
            professor.getMatricula ( ) != null &&
            professor.getEndereco ( )  != null &&
            professor.getTelefone ( )  != null) {

    	    professorService.salvarProfessor (professor);
    	    return true;
        }

        return false;
    }

    @RequestMapping(value="/professor/{matricula}", method = RequestMethod.DELETE)
    public boolean excluirProfessor(@PathVariable String matricula) {
	    professor = professorService.encontrarProfessorPelaMatricula (matricula);

	    if(professor!=null){
		    professorService.excluirProfessor (professor.getId ( ));
		    return true;
	    }

	    return false;
    }
   
    @RequestMapping(value="/professor", method=RequestMethod.PUT)
    public boolean editar(@RequestBody ProfessorRequestBody requestBody) {
	    professor = professorService.encontrarProfessorPelaMatricula (
            requestBody.getMatricula ( )
        );

	    if (professor!=null){
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
