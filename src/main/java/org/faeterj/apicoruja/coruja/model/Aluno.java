package org.faeterj.apicoruja.coruja.model;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
public class Aluno {

    private Integer id;
    private String nome;
    private Integer matricula;

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
