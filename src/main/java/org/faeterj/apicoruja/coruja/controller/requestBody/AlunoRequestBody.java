package org.faeterj.apicoruja.coruja.controller.requestBody;

/**
 * Created by Gabriel Capanema on 23/06/17.
 */
public class AlunoRequestBody {

    public String nome;
    public String matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
