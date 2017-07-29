package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.DisciplinaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Marcos Felipe on 19/07/17.
 */

@RestController
public class DisciplinaController {

    private DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController (DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @RequestMapping(value="/disciplina", method=RequestMethod.GET)
    public List<Disciplina> listarDisciplinas ( ) {
        return disciplinaService.obterDisciplinas ( );
    }

    @RequestMapping(value="/disciplina", method=RequestMethod.POST)
    public Disciplina adicionarDisciplina (@RequestBody DisciplinaRequestBody requestBody) {
        return disciplinaService.adicionarDisciplina (
        	new Disciplina (requestBody)
        );
    }

    @RequestMapping(value="/disciplina/nome/{nome}", method=RequestMethod.GET)
    public List<Disciplina> obterDisciplinaPorNome (@PathVariable String nome) {
        return disciplinaService.obterDisciplinaPorNome (nome);
    }

    @RequestMapping(value="/disciplina/cargaHoraria/{cargaHoraria}", method=RequestMethod.GET)
    public List<Disciplina> obterDisciplinaPorCargaHoraria (@PathVariable Double cargaHoraria) {
        return disciplinaService.obterDisciplinaPorCargaHoraria (cargaHoraria);
    }

    @RequestMapping(value="/disciplina/descricao/{descricao}", method=RequestMethod.GET)
    public List<Disciplina> obterDisciplinaPorDescricao (@PathVariable String descricao) {
        return disciplinaService.obterDisciplinaPorDescricao (descricao);
    }

    @RequestMapping(value="/disciplina/sigla/{sigla}", method=RequestMethod.GET)
    public Disciplina obterDisciplinaPorSigla (@PathVariable String sigla) {
        return disciplinaService.obterDisciplinaPorSigla (sigla);
    }

    @RequestMapping(value="/disciplina", method=RequestMethod.PUT)
    public Disciplina alterarDisciplinaPorSigla (@RequestBody DisciplinaRequestBody requestBody) {
        Disciplina d = disciplinaService.obterDisciplinaPorSigla (requestBody.sigla);

        if (d != null) {
            d.setNome (requestBody.nome);
            d.setCargaHoraria (requestBody.cargaHoraria);
            d.setDescricao (requestBody.descricao);

            disciplinaService.alterarDisciplina (d);
        }

        return d;
    }

    @RequestMapping(value="/disciplina/sigla/{sigla}", method=RequestMethod.DELETE)
    public Disciplina removerDisciplina (@PathVariable String sigla) {
        Disciplina d = disciplinaService.obterDisciplinaPorSigla (sigla);

        if (d != null) {
            disciplinaService.removerDisciplina (d);
        }

        return d;
    }

}
