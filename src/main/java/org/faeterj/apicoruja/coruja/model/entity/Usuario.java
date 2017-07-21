package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

/**
 * Created by Rodrigo Sudano on 21-Jul-17.
 */

@MappedSuperclass
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="usuario_id")
    private long id;

    @Column(name="matricula", unique=true)
    private String matricula;

    @Column(name="senha")
    private String senha;

    public Usuario (long id, String matricula, String senha)
    {
        this.id        = id;
        this.matricula = matricula;
        this.senha = senha;
    }

    protected Usuario ( ) { }

    public long getId ( ) {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getSenha ( ) { return senha; }

    public void setSenha (String senha) { this.senha = senha; }

    public String getMatricula ( ) {
        return matricula;
    }

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }


}
