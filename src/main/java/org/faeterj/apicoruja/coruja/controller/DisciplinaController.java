package org.faeterj.apicoruja.coruja.controller;

import
  org.faeterj.apicoruja.coruja.controller.requestBody.DisciplinaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Disciplina;
import org.faeterj.apicoruja.coruja.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Marcos Felipe on 19/07/17.
 */

/**
 * Modified by William Lemos on 23/07/17.
 */
@RestController
public class DisciplinaController {

    private DisciplinaService service;

    @Autowired
    public DisciplinaController (DisciplinaService service) {
        this.service = service;
    }
    
    // ========================================================================

    /*
    @DeleteMapping(value="/disciplina")
    public boolean removerDisciplina (@RequestBody String sigla) {
    	return service.removerDisciplina (sigla);
    }
    */

    @DeleteMapping(value="/disciplina/sigla/{sigla}")
    public Disciplina removerDisciplina (@PathVariable String sigla) {
        Disciplina d = service.obterDisciplinaPorSigla (sigla);

        if (d != null) {
            service.removerDisciplina (d.getSigla ( ));
        }

        return d;
    }
    
    // -----------------------------------------------------------------------
    
    @GetMapping(value="/disciplina")
    public List<Disciplina> listarDisciplinas ( ) {
        return service.obterDisciplinas ( );
    }

    /*
    @RequestMapping(value="/DisciplinaTodas", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplina() {
        return DisciplinaService.obterTodasDisciplinas();
    }
    */

    // -----------------------------------------------------------------------

    @PostMapping(value="/disciplina")
    public Disciplina adicionarDisciplina (@RequestBody DisciplinaRequestBody requestBody) {
    	Disciplina d = new Disciplina (requestBody);

        service.adicionarDisciplina (d);

        return d;
    }

    /*
    @PostMapping(value="/disciplina")
    public boolean adicionarDisciplina (@RequestBody DisciplinaRequestBody requestBody) {
    	Disciplina nova = new Disciplina (requestBody);

        return service.adicionarDisciplina (nova);
    }
    */

    // -------------------------------------------------------
    
    @GetMapping(value="/disciplina/nome/{nome}")
    public List<Disciplina> obterDisciplinaPorNome (@PathVariable String nome) {
        return service.obterDisciplinaPorNome (nome);
    }

    @GetMapping(value="/disciplina/carga-horaria/{cargaHoraria}")
    public List<Disciplina> obterDisciplinaPorCargaHoraria (@PathVariable double cargaHoraria) {
        return service.obterDisciplinaPorCargaHoraria (cargaHoraria);
    }

    /*
    @GetMapping(value="/disciplina/carga/{carga}")
    public List<Disciplina> listarDisciplinaPorCargaHoraria (@RequestBody double cargaHoraria) {
    	return service.obterDisciplinaCargaHoraria (cargaHoraria);
    }
    */
    
    @GetMapping(value="/disciplina/descricao/{descricao}")
    public List<Disciplina> obterDisciplinaPorDescricao (@PathVariable String descricao) {
        return service.obterDisciplinaPorDescricao (descricao);
    }

    @GetMapping(value="/disciplina/sigla/{sigla}")
    public Disciplina obterDisciplinaPorSigla (@PathVariable String sigla) {
        return service.obterDisciplinaPorSigla (sigla);
    }
    
    // ------------------------------------------------------------------------------

    @PutMapping(value="/disciplina")
    public Disciplina alterarDisciplinaPorSigla (@RequestBody DisciplinaRequestBody requestBody) {
        Disciplina d = service.obterDisciplinaPorSigla (requestBody.sigla);

        if (d != null) {
            d.setNome (requestBody.nome);
            d.setCargaHoraria (requestBody.cargaHoraria);
            d.setDescricao (requestBody.descricao);

            service.alterarDisciplina (d);
        }

        return d;
    }

    /*
    @PutMapping(value="/disciplina")
    public boolean alterarDisciplina (@RequestBody String siglaAntiga, DisciplinaRequestBody requestBody) {
    	Disciplina nova   = new Disciplina (requestBody);
    	Disciplina antiga = service.obterDisciplinaPorSigla (siglaAntiga);

    	nova.setId (antiga.getId ( ));
    	
    	service.removerDisciplina (siglaAntiga);
        service.adicionarDisciplina (nova);

        return true;
    }
    */
    
}

// OK