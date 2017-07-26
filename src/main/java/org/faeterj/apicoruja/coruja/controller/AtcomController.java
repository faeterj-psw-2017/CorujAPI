package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.service.AtcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public class AtcomController {

    @Autowired
    private AtcomService atcomService;

    //busca
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ATCOM get(@PathVariable(value = "atcomId") String atcomId){
        return atcomService.findById(atcomId);
    }

    //inserirDocumento
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ATCOM create(@RequestBody ATCOM atcom){
        return atcomService.create(atcom);
    }

    //inseriHoras

    //listaHoras  -  busca as horas do aluno pela matricula
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ATCOM> findAll(){
        return atcomService.findAll();
    }

    //validaHoras


    //editaHoras
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ATCOM update(@RequestBody ATCOM atcom){
        return atcomService.update(atcom);
    }

    //excluiHoras
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{atcomId}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "atcomId") String atcomId){
        atcomService.delete(atcomId);
    }
}
