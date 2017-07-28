package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;
import org.faeterj.apicoruja.coruja.model.repository.ATCOMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class AtcomService {

    private ATCOMRepository atcomRepositorio;

    @Autowired
    public AtcomService (ATCOMRepository atcomRepositorio) {
        this.atcomRepositorio = atcomRepositorio;
    }

    @PostConstruct
    public void init ( ) {
    }

    public ATCOM create (ATCOM atcom) {
        return atcomRepositorio.save (atcom);
    }

    public void delete (Long id) {
        atcomRepositorio.delete (id);
    }

    public List<ATCOM> listarAtcom ( ) {
        Iterable<ATCOM> iterable = atcomRepositorio.findAll ( );
        List<ATCOM> list = new ArrayList<ATCOM> ( );

        for (ATCOM atcom : iterable) {
            list.add (atcom);
        }

        return list;
    }

    public ATCOM encontrarAtcomPeloId (Long id) {
        return atcomRepositorio.findOne (id);
    }

    public ATCOM atualiza (ATCOM atcom) {
        return atcomRepositorio.save (atcom);
    }

}
