package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.repository.ATCOMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtcomService {


    private ATCOMRepository atcomRepositorio;

    @Autowired
    public AtcomService (ATCOMRepository atcomRepositorio) { this.atcomRepositorio = atcomRepositorio; }

    @PostConstruct
    public void init ( ) {
    }

    public ATCOM create (ATCOM atcom) { return atcomRepositorio.save (atcom);    }

    public  void delete(Long id){atcomRepositorio.delete(id);}

    public ATCOM encontrarAtcomPeloId (Long id) {        return atcomRepositorio.findOne (id);    }

    public List<ATCOM> listarAtcom ( ) {
        Iterable<ATCOM> iterable = atcomRepositorio.findAll ( );
        List<ATCOM> list = new ArrayList<ATCOM>( );

        for (ATCOM atcom : iterable) {
            list.add (atcom);
        }

        return list;
    }

}