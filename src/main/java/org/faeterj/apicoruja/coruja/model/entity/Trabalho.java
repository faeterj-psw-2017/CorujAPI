package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Table(name="trabalho")
@Entity
public class Trabalho {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name="trabalho_id")
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="aluno_id")
    private long id_aluno;

    /*@Column(name="matricula", unique=true)
    private long matricula;
     */
    // ======================================================

    public Trabalho (long id, String nome, long id_aluno) {
        this.id        = id;
        this.nome      = nome;
        this.id_aluno = id_aluno;
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

    public long getIdAluno ( ) {
        return id_aluno;
    }

    public void setgetIdAluno (long id_aluno) {
        this.id_aluno = id_aluno;
    }

    // =========================================================================

    @Override
    public String toString ( ) {
        return String.format ("Trabalho(matricula=%d, nome=%s)", id_aluno, nome);
    }
}

// OK
