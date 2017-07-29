package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.faeterj.apicoruja.coruja.controller.requestBody.AlunoRequestBody;
import javax.persistence.*;

@Entity
@Table(name="aluno")
public final class Aluno extends Pessoa {

    @Id
    @Column(name="aluno_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne(optional=true)
    @JoinColumn(name                 = "historico",
                referencedColumnName = "historico_id",
                nullable             = true)
    private Historico historico;

    @Column(name="matricula", unique=true, nullable=false)
    private String matricula;

    // ====================================================

    public Aluno ( ) {

    }

    public Aluno (Historico historico, String matricula) {
        this.historico = historico;
        this.matricula = matricula;
    }

    public Aluno (String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
    }

    public Aluno (
        String nome, String telefone, String endereco, char sexo
    ) {
        super(nome, telefone, endereco, sexo);
    }

    public Aluno (
        String nome,
        String telefone,     String endereco,
        Historico historico, String matricula
    ) {
        this(historico, matricula);

        this.nome     = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Aluno (AlunoRequestBody requestBody) {
        this (
            requestBody.nome,
            requestBody.telefone,
            requestBody.endereco,
            null,
            requestBody.matricula
        );

        if (requestBody.historico == null) {
        	this.historico = null;
        }
        else {
        	this.historico = new Historico (requestBody.historico);
        }
        
        this.sexo = requestBody.sexo;
        this.cpf  = requestBody.cpf;
        this.rg   = requestBody.rg;
    }

    // ==========================================

    public void setId (Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Long getId ( ) {
        return id;
    }

    // ---------------------------------------------

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula ( ) {
        return matricula;
    }

    // ------------------------------------

    public Historico getHistorico ( ) {
        return historico;
    }

    public void setHistorico (Historico historico) {
        this.historico = historico;
    }

}

// OK
