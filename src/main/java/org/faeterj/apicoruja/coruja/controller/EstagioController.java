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

    private EstagioService estagioService;

    @Autowired
    public EstagioController(EstagioService estagioService) {
        this.estagioService = estagioService;
    }

    @RequestMapping(value="/estagio", method = RequestMethod.GET)
    public List<Estagio> listarEstagios() {
        return estagioService.obterEstagios();
    }

    @RequestMapping(value="/estagio", method = RequestMethod.POST)
    public Estagio adicionarEstagio(@RequestBody EstagioRequestBody requestBody) {
        return estagioService.adicionarEstagio(requestBody.getAluno(), requestBody.getEmpresa(), requestBody.getFuncao(), requestBody.getDataInicio(), requestBody.getDataFim(), requestBody.getHoras());
    }

    @RequestMapping(value="/estagio/aluno/{aluno}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorAluno(@PathVariable Aluno aluno) {
        return estagioService.obterEstagioPorAluno(aluno);
    }

    @RequestMapping(value="/estagio/empresa/{empresa}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorEmpresa(@PathVariable String empresa) {
        return estagioService.obterEstagioPorEmpresa(empresa);
    }

    @RequestMapping(value="/estagio/funcao/{funcao}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorFuncao(@PathVariable String funcao) {
        return estagioService.obterEstagioPorFuncao(funcao);
    }

    @RequestMapping(value="/estagio/dataInicio/{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorDataInicio(@PathVariable Date data) {
        return estagioService.obterEstagioPorDataInicio(data);
    }

    @RequestMapping(value="/estagio/dataInicio/dataInicio>{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoAPartirDe(@PathVariable Date data) {
        return estagioService.obterEstagioIniciadoAPartirDe(data);
    }

    @RequestMapping(value="/estagio/dataInicio/dataInicio<{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoAte(@PathVariable Date data) {
        return estagioService.obterEstagioIniciadoAte(data);
    }

    @RequestMapping(value="/estagio/dataInicio/{dataInicial}<dataInicio<{dataFinal}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioIniciadoEntre(@PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return estagioService.obterEstagioIniciadoEntre(dataInicial, dataFinal);
    }

    @RequestMapping(value="/estagio/dataFim/{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorDataFim(@PathVariable Date data) {
        return estagioService.obterEstagioPorDataFim(data);
    }

    @RequestMapping(value="/estagio/dataFim/dataFim>{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoAPartirDe(@PathVariable Date data) {
        return estagioService.obterEstagioTerminadoAPartirDe(data);
    }

    @RequestMapping(value="/estagio/dataFim/dataFim<{data}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoAte(@PathVariable Date data) {
        return estagioService.obterEstagioTerminadoAte(data);
    }

    @RequestMapping(value="/estagio/dataFim/{dataInicial}<dataFim<{dataFinal}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioTerminadoEntre(@PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return estagioService.obterEstagioTerminadoEntre(dataInicial, dataFinal);
    }

    @RequestMapping(value="/estagio/horas/{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHoras(@PathVariable float horas) {
        return estagioService.obterEstagioPorHoras(horas);
    }

    @RequestMapping(value="/estagio/horas/horas>{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasAcimaDe(@PathVariable float horas) {
        return estagioService.obterEstagioPorHorasAcimaDe(horas);
    }

    @RequestMapping(value="/estagio/horas/horas<{horas}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasAbaixoDe(@PathVariable float horas) {
        return estagioService.obterEstagioPorHorasAbaixoDe(horas);
    }

    @RequestMapping(value="/estagio/horas/{horasMinimo}<horas<{horasMaximo}", method = RequestMethod.GET)
    public List<Estagio> obterEstagioPorHorasEntre(@PathVariable float horasMinimo, @PathVariable float horasMaximo) {
        return estagioService.obterEstagioPorHorasEntre(horasMinimo, horasMaximo);
    }

    @RequestMapping(value="/estagioAlterar", method = RequestMethod.POST)
    public Estagio alterarEstagioPorID(@RequestBody EstagioRequestBody requestBody) {
        Estagio e = estagioService.obterEstagioPorID(requestBody.getId());
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

    @RequestMapping(value="/estagioRemover", method = RequestMethod.POST)
    public Estagio removerEstagio(@RequestBody EstagioRequestBody requestBody) {
        Estagio e = estagioService.obterEstagioPorID(requestBody.getId());
        if (e != null) {
            estagioService.removerEstagio(e);
        }
        return e;
    }

}
