package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.service.AtcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public class AtcomController {

    private AtcomService atcomService;

    @Autowired
    public AtcomController (AtcomService atcomService) {
        this.atcomService = atcomService;
    }

    /*busca
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/atcom/{atcomId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ATCOM get(@PathVariable(value = "atcomId") Aluno aluno){

        return atcomService.listarPorAluno(ATCOM);
    }*/

    //inserirDocumento
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/atcom/create", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ATCOM create(@RequestBody ATCOM atcom){
        return atcomService.create(atcom);
    }

    //listaHoras
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/atcom/findAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ATCOM> findAll(){
        return atcomService.listarAtcom();
    }

    //excluiHoras
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/atcom/{atcomId}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "atcomId") Long atcomId){
        atcomService.delete(atcomId);
    }
}
