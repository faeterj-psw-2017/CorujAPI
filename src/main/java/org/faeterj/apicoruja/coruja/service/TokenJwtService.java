package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.TokenJwt;
import org.faeterj.apicoruja.coruja.model.repository.TokenJwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Rodrigo Sudano on 22-Jul-17.
 */

@Service
public class TokenJwtService
{
    private TokenJwtRepository repo;

    @Autowired
    public TokenJwtService (TokenJwtRepository repo){
        this.repo = repo;
    }

    public TokenJwt getTokenJwt(String matricula)
    {
        return repo.findByMatricula(matricula);
    }

    public String setTokenJwt(TokenJwt token)
    {
        // precisa try/catch para erro de insercao?
        repo.save(token);
        return "ok";
    }

}
