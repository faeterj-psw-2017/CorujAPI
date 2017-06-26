package org.faeterj.apicoruja.coruja.controller.requestBody;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
public class AlunoRequestBody {

    public String nome;
    public Integer matricula;

    public String getNome() {
        return nome;
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
