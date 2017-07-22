package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Usuario;
import org.faeterj.apicoruja.coruja.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Created by Rodrigo Sudano on 21-Jul-17.
 */

@Service
public class UsuarioService
{

    private UsuarioRepository repo;

    @Autowired
    public UsuarioService (UsuarioRepository repo){
        this.repo = repo;
    }

    @PostConstruct
    public void init() {

        Usuario usuario = new Usuario(new Long(1), "123", "123");
        repo.save(usuario);
    }

    public Usuario getUsuario(String matricula)
    {
        return repo.findByMatricula(matricula);
    }

}
