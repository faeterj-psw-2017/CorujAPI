package org.faeterj.apicoruja.coruja.model.entity;

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

    public Aluno (Long id, Historico historico, String matricula) {
        this.id        = id;
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
        long id,             String nome,
        String telefone,     String endereco,
        Historico historico, String matricula
    ) {
        this(id, historico, matricula);

        this.nome     = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // ==============================

    public void setId (Long id) {
        this.id = id;
    }

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
