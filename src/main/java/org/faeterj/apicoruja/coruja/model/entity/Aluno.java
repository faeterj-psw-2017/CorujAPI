package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Table(name="aluno")
@Entity
public class Aluno {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name="aluno_id")
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="matricula", unique=true)
    private long matricula;

    // ======================================================

    public Aluno (long id, String nome, long matricula) {
        this.id        = id;
        this.nome      = nome;
        this.matricula = matricula;
    }

    protected Aluno ( ) {
    
    }

    // =============================================

    public long getId ( ) {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    // ----------------------------------------------

    public String getNome ( ) {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;

    }

    // -----------------------------------------------

    public long getMatricula ( ) {
        return matricula;
    }

    public void setMatricula (long matricula) {
        this.matricula = matricula;
    }

    // =========================================================================

    @Override
    public String toString ( ) {
        return String.format ("Aluno(matricula=%d, nome=%s)", matricula, nome);
    }
}

// OK
