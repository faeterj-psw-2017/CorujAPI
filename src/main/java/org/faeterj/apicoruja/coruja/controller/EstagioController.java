package org.faeterj.apicoruja.coruja.controller;

/**
 * Created with IntelliJ IDEA.
 * User: Marcos Felipe
 * Date: 21/07/17
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
import org.faeterj.apicoruja.coruja.controller.requestBody.EstagioRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;
import org.faeterj.apicoruja.coruja.service.EstagioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return estagioService.adicionarEstagio(requestBody.getAluno(), requestBody.getEmpresa(), requestBody.getFuncao(), requestBody.getDataInicio());
    }

    public void removerEstagio() {

    }

    public void obterEstagio() {

    }

}
