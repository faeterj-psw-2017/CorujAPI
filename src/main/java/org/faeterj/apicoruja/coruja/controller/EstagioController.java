package org.faeterj.apicoruja.coruja.controller;

/**
 * Created with IntelliJ IDEA.

 * User: Marcos Felipe
 * Date: 21/07/17
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */

import org.faeterj.apicoruja.coruja.controller.requestBody.EstagioRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;
import org.faeterj.apicoruja.coruja.service.EstagioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class EstagioController {

    private EstagioService service;

    @Autowired
    public EstagioController (EstagioService service) {
        this.service = service;
    }
    
    // ==================================================================
    
    @GetMapping(value="/estagio/cancelado")
    public List<Estagio> cancelados ( ) {
    	return service.obterEstagiosCancelados ( );
    }
 
    @GetMapping(value="/estagio/nao-cancelado")
    public List<Estagio> naoCancelados ( ) {
    	return service.obterEstagiosNaoCancelados ( );
    }
    
    // ------------------------------------------------------------
    
    @RequestMapping(value="/estagio", method=RequestMethod.GET)
    public List<Estagio> listarEstagios ( ) {
        return service.obterEstagios ( );
    }

    @PostMapping(value="/estagio")
    public Estagio adicionarEstagio (@RequestBody EstagioRequestBody body) {
        return service.adicionarEstagio (
        	new Estagio (body)
        );
    }
    
    // ------------------------------------------------------------------------

    @GetMapping(value="/estagio/aluno/{aluno}")
    public List<Estagio> obterEstagioPorAluno (@PathVariable Aluno aluno) {
        return service.obterEstagioPorAluno (aluno);
    }

    @GetMapping(value="/estagio/empresa/{empresa}")
    public List<Estagio> obterEstagioPorEmpresa (@PathVariable String empresa) {
        return service.obterEstagioPorEmpresa (empresa);
    }

    @GetMapping(value="/estagio/funcao/{funcao}")
    public List<Estagio> obterEstagioPorFuncao (@PathVariable String funcao) {
        return service.obterEstagioPorFuncao (funcao);
    }
    
    // -----------------------------------------------------------------

    @GetMapping(value="/estagio/data-inicio/{data}")
    public List<Estagio> obterEstagioPorDataInicio (@PathVariable Date data) {
        return service.obterEstagioPorDataInicio (data);
    }

    @GetMapping(value="/estagio/data-inicio/depois/{data}")
    public List<Estagio> obterEstagioIniciadoAPartirDe (@PathVariable Date data) {
        return service.obterEstagioIniciadoAPartirDe (data);
    }

    @GetMapping(value="/estagio/data-inicio/antes/{data}")
    public List<Estagio> obterEstagioIniciadoAte (@PathVariable Date data) {
        return service.obterEstagioIniciadoAte (data);
    }

    @GetMapping(value="/estagio/data-inicio/entre/{dataInicial}/{dataFinal}")
    public List<Estagio> obterEstagioIniciadoEntre (
    	@PathVariable Date dataInicial,
    	@PathVariable Date dataFinal
    ) {
        return service.obterEstagioIniciadoEntre (dataInicial, dataFinal);
    }

    // --------------------------------------------------------------------
    
    @GetMapping(value="/estagio/data-fim/{data}")
    public List<Estagio> obterEstagioPorDataFim (@PathVariable Date data) {
        return service.obterEstagioPorDataFim (data);
    }

    @GetMapping(value="/estagio/data-fim/depois/{data}")
    public List<Estagio> obterEstagioTerminadoAPartirDe(@PathVariable Date data) {
        return service.obterEstagioTerminadoAPartirDe(data);
    }

    @GetMapping(value="/estagio/data-fim/antes/{data}")
    public List<Estagio> obterEstagioTerminadoAte (@PathVariable Date data) {
        return service.obterEstagioTerminadoAte (data);
    }

    @GetMapping(value="/estagio/data-fim/entre/{dataInicial}/{dataFinal}")
    public List<Estagio> obterEstagioTerminadoEntre (@PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return service.obterEstagioTerminadoEntre (dataInicial, dataFinal);
    }

    // --------------------------------------------------------------------
    
    @GetMapping(value="/estagio/horas/{horas}")
    public List<Estagio> obterEstagioPorHoras (@PathVariable float horas) {
        return service.obterEstagioPorHoras (horas);
    }

    @GetMapping(value="/estagio/horas/acima/{horas}")
    public List<Estagio> obterEstagioPorHorasAcimaDe (@PathVariable float horas) {
        return service.obterEstagioPorHorasAcimaDe (horas);
    }

    @GetMapping(value="/estagio/horas/abaixo/{horas}")
    public List<Estagio> obterEstagioPorHorasAbaixoDe (@PathVariable float horas) {
        return service.obterEstagioPorHorasAbaixoDe (horas);
    }

    @RequestMapping(value="/estagio/horas/entre/{horasMinimo}/{horasMaximo}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasEntre (@PathVariable float horasMinimo, @PathVariable float horasMaximo) {
        return service.obterEstagioPorHorasEntre (horasMinimo, horasMaximo);
    }

    // ---------------------------------------------------------------------
    
    @PutMapping("/estagio")
    public Estagio alterarPorId (@RequestBody EstagioRequestBody body) {
        Estagio e = service.obterPorId (body.id);

        if (e != null) {
            Estagio e2 = new Estagio (body);

            e2.setId (e.getId ( ));
            service.adicionarEstagio (e2);
        }

        return e;
    }

    @DeleteMapping("/estagio/{id}")
    public void apagar (@PathVariable long id) {
    	service.apagar (id);
    } 

}
