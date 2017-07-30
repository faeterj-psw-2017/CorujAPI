package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

import org.faeterj.apicoruja.coruja.controller.requestBody.TrabalhoRequestBody;

@Table(name="trabalho")
@Entity
public final class Trabalho {

    @Column(name="trabalho_id", updatable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="titulo", nullable=false)
    private String titulo;

    @ManyToOne(optional=false)
    @JoinColumn(name                 ="turma",
                referencedColumnName = "turma_id",
                nullable             = false,
                updatable            = false)
    private Turma turma;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "aluno",
                referencedColumnName = "aluno_id",
                nullable             = false,
                updatable            = false)
    private Aluno aluno;

    // ==============================================

    protected Trabalho ( ) {

    }

    public Trabalho (String titulo) {
        this.titulo = titulo;
    }

    public Trabalho (TrabalhoRequestBody requestBody) {
    	this.titulo = requestBody.titulo;

    	if (requestBody.aluno != null) {
    		this.aluno = new Aluno (requestBody.aluno);
    	}
    	
    	if (requestBody.turma != null) {
    		this.turma = new Turma (requestBody.turma);
    	}
    }
    
    // ==========================================

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId ( ) {
        return id;
    }

    // ----------------------------------------

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo ( ) {
        return titulo;
    }

    // ------------------------------------------------

    public Aluno getAluno ( ) {
        return aluno;
    }

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    // ------------------------------------

    public Turma getTurma ( ) {
        return turma;
    }

    public void setTurma (Turma turma) {
        this.turma = turma;
    }

}

// OK
