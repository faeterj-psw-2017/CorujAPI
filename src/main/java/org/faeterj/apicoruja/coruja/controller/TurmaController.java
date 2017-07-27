package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.TurmaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by William Lemos on 23/07/17.
 */

@RestController
public class TurmaController {

    private TurmaService TurmaService;

    @Autowired
    public TurmaController(TurmaService TurmaService) {
        this.TurmaService = TurmaService;
    }

    @RequestMapping(value="/turmaTodas", method = RequestMethod.GET)
    public List<Turma> listarTurma() {
        return TurmaService.obterTodasTurmas();
    }
    
    @RequestMapping(value="/turmaCodigo", method = RequestMethod.GET)
    public List<Turma> listarTurmaCodigo(@RequestBody String codigo) {
        return TurmaService.obterTurmasCodigo(codigo);
    }
    
    @RequestMapping(value="/turmaTurno", method = RequestMethod.GET)
    public List<Turma> listarTurmaTurno(@RequestBody char turno) {
        return TurmaService.obterTurmasTurno(turno);
    }

    @RequestMapping(value="/turma", method = RequestMethod.POST)
    public boolean adicionarTurma(@RequestBody TurmaRequestBody requestBody) {
    	Turma turma = new Turma();
    	turma.setCodigo(requestBody.getCodigo());
    	turma.setSala(requestBody.getSala());
    	turma.setTurno(requestBody.getTurno());
        return TurmaService.adicionarTurma(turma);
    }

    @RequestMapping(value="/turma", method = RequestMethod.DELETE)
    public boolean removerTurma(@RequestBody TurmaRequestBody requestBody) {
    	Turma turma = new Turma();
    	turma.setCodigo(requestBody.getCodigo());
    	turma.setSala(requestBody.getSala());
    	turma.setTurno(requestBody.getTurno());
    	return TurmaService.removerTurma(turma);
    }

    @RequestMapping(value="/turma", method = RequestMethod.PUT)
    public void alterarTurma(@RequestBody TurmaRequestBody requestBodyOriginal, TurmaRequestBody requestBodyAlterar) {
    	Turma original = new Turma();
    	original.setCodigo(requestBodyOriginal.getCodigo());  
    	original.setSala(requestBodyOriginal.getSala());
    	original.setTurno(requestBodyOriginal.getTurno());
    	
    	Turma alterar = new Turma ();
    	alterar.setCodigo(requestBodyAlterar.getCodigo());
    	alterar.setSala(requestBodyAlterar.getSala());
    	alterar.setTurno(requestBodyAlterar.getTurno());
    	TurmaService.alterarTurma(original, alterar);
    }

}
