package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Rodrigo Sudano on 21-Jul-17.
 */
public class UsuarioService
{

    private UsuarioRepository repo;

    @Autowired
    public UsuarioService (UsuarioRepository repo){
        this.repo = repo;
    }

}
