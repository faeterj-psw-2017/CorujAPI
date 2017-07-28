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
    
    @RequestMapping(value="/estagio/cancelado", method=RequestMethod.GET)
    public List<Estagio> cancelados ( ) {
    	return service.obterEstagiosCancelados ( );
    }
 
    @RequestMapping(value="/estagio/nao-cancelado", method=RequestMethod.GET)
    public List<Estagio> naoCancelados ( ) {
    	return service.obterEstagiosNaoCancelados ( );
    }
    
    // ------------------------------------------------------------
    
    @RequestMapping(value="/estagio", method=RequestMethod.GET)
    public List<Estagio> listarEstagios ( ) {
        return service.obterEstagios ( );
    }

    @RequestMapping(value="/estagio", method=RequestMethod.POST)
    public Estagio adicionarEstagio (@RequestBody EstagioRequestBody requestBody) {
        return service.adicionarEstagio (
        	new Estagio (requestBody)
        );
    }
    
    // ------------------------------------------------------------------------

    @RequestMapping(value="/estagio/aluno/{aluno}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioPorAluno (@PathVariable Aluno aluno) {
        return service.obterEstagioPorAluno (aluno);
    }

    @RequestMapping(value="/estagio/empresa/{empresa}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioPorEmpresa (@PathVariable String empresa) {
        return service.obterEstagioPorEmpresa (empresa);
    }

    @RequestMapping(value="/estagio/funcao/{funcao}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioPorFuncao (@PathVariable String funcao) {
        return service.obterEstagioPorFuncao (funcao);
    }

    @RequestMapping(value="/estagio/dataInicio/{data}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioPorDataInicio (@PathVariable Date data) {
        return service.obterEstagioPorDataInicio (data);
    }

    @RequestMapping(value="/estagio/dataInicio/dataInicio>{data}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoAPartirDe (@PathVariable Date data) {
        return service.obterEstagioIniciadoAPartirDe (data);
    }

    @RequestMapping(value="/estagio/dataInicio/dataInicio<{data}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoAte (@PathVariable Date data) {
        return service.obterEstagioIniciadoAte (data);
    }

    @RequestMapping(value="/estagio/data/{dataInicial}/{dataFinal}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoEntre (
    	@PathVariable Date dataInicial,
    	@PathVariable Date dataFinal
    ) {
        return service.obterEstagioIniciadoEntre (dataInicial, dataFinal);
    }

    @RequestMapping(value="/estagio/dataFim/{data}", method=RequestMethod.GET)
    public List<Estagio> obterEstagioPorDataFim (@PathVariable Date data) {
        return service.obterEstagioPorDataFim (data);
    }

    @RequestMapping(value="/estagio/dataFim/dataFim>{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoAPartirDe(@PathVariable Date data) {
        return service.obterEstagioTerminadoAPartirDe(data);
    }

    @RequestMapping(value="/estagio/dataFim/dataFim<{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoAte (@PathVariable Date data) {
        return service.obterEstagioTerminadoAte (data);
    }

    @RequestMapping(value="/estagio/dataFim/{dataInicial}<dataFim<{dataFinal}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoEntre (@PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return service.obterEstagioTerminadoEntre (dataInicial, dataFinal);
    }

    @RequestMapping(value="/estagio/horas/{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHoras (@PathVariable float horas) {
        return service.obterEstagioPorHoras (horas);
    }

    @RequestMapping(value="/estagio/horas/horas>{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasAcimaDe (@PathVariable float horas) {
        return service.obterEstagioPorHorasAcimaDe (horas);
    }

    @RequestMapping(value="/estagio/horas/horas<{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasAbaixoDe (@PathVariable float horas) {
        return service.obterEstagioPorHorasAbaixoDe (horas);
    }

    @RequestMapping(value="/estagio/horas/{horasMinimo}<horas<{horasMaximo}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasEntre (@PathVariable float horasMinimo, @PathVariable float horasMaximo) {
        return service.obterEstagioPorHorasEntre (horasMinimo, horasMaximo);
    }

    /*
    @RequestMapping(value="/estagio", method = RequestMethod.POST)
    public Estagio alterarEstagioPorID(@RequestBody EstagioRequestBody requestBody) {
        Estagio e = estagioService.obterEstagioPorID (requestBody.getId ( ));

        if (e != null) {
            e.setAluno(requestBody.getAluno());
            e.setEmpresa(requestBody.getEmpresa());
            e.setFuncao(requestBody.getFuncao());
            e.setDataInicio(requestBody.getDataInicio());
            e.setDataFim(requestBody.getDataFim());
            e.setHoras(requestBody.getHoras());
            estagioService.alterarEstagio(e);
        }

        return e;
    }
    */

    // estagio nao pode ser removido, apenas cancelado
}
