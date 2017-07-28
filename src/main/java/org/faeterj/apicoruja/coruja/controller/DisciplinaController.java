package org.faeterj.apicoruja.coruja.controller;

import java.util.List;

import org.faeterj.apicoruja.coruja.controller.requestBody.DisciplinaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by William Lemos on 23/07/17.
 */

@RestController
public class DisciplinaController {

    private DisciplinaService DisciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService DisciplinaService) {
        this.DisciplinaService = DisciplinaService;
    }

    @RequestMapping(value="/DisciplinaTodas", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplina() {
        return DisciplinaService.obterTodasDisciplinas();
    }
    
    @RequestMapping(value="/DisciplinaSigla", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplinaPorSigla (@RequestBody String sigla) {
    	return DisciplinaService.obterDisciplinaPorSigla(sigla);
    }
    
    @RequestMapping(value="/DisciplinaCarga", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplinaPorCargaHoraria (@RequestBody double cargaHoraria) {
    	return DisciplinaService.obterDisciplinaCargaHoraria(cargaHoraria);
    }
    
    @RequestMapping(value="/DisciplinaAdicionar", method = RequestMethod.POST)
    public boolean adicionarDisciplina(@RequestBody DisciplinaRequestBody requestBody) {
    	Disciplina nova = new Disciplina();
    	nova.setNome(requestBody.getNome());
    	nova.setSigla(requestBody.getSigla());
    	nova.setCargaHoraria(requestBody.getCargaHoraria());
    	nova.setDescricao(requestBody.getDescricao());
        return DisciplinaService.adicionarDisciplina(nova);
    }
    
    @RequestMapping(value="/DisciplinaRemover", method = RequestMethod.DELETE)
    public boolean removerDisciplina(@RequestBody String sigla) {
    	return DisciplinaService.removerDisciplina(sigla);
    }
    

    @RequestMapping(value="/DisciplinaAlterar", method = RequestMethod.POST)
    public boolean alterarDisciplina(@RequestBody String siglaAntiga, DisciplinaRequestBody requestBody) {
    	Disciplina nova = new Disciplina();
    	nova.setNome(requestBody.getNome());
    	nova.setSigla(requestBody.getSigla());
    	nova.setCargaHoraria(requestBody.getCargaHoraria());
    	nova.setDescricao(requestBody.getDescricao());
        return DisciplinaService.alterarDisciplina(siglaAntiga, nova);
    }
}
