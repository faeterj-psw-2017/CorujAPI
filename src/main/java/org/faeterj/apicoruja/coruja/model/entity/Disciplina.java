package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

import org.faeterj.apicoruja.coruja.controller.requestBody.DisciplinaRequestBody;

@Table(name="disciplina")
@Entity
public final class Disciplina {

    @Column(name="disciplina_id", updatable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="sigla", unique=true, nullable=false)
    private String sigla;

    @Column(name="carga_horaria", nullable=false)
    private double cargaHoraria;

    @Column(name="descricao", nullable=false)
    private String descricao;

    // ====================================

    public Disciplina ( ) {

    }

    public Disciplina (
        String nome,         String sigla,
        double cargaHoraria, String descricao
    ) {
        this.nome         = nome;
        this.sigla        = sigla;
        this.cargaHoraria = cargaHoraria;
        this.descricao    = descricao;
    }

    public Disciplina (DisciplinaRequestBody requestBody) {
    	this (
    		requestBody.nome,
    		requestBody.sigla,
    		requestBody.cargaHoraria,
    		requestBody.descricao
    	);
    }
    
    // =====================================================================

    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
    	this.id = id;
    }

    // ---------------------------------

    public String getNome ( ) {
        return nome;
    }
	
    public void setNome (String nome) {
        this.nome = nome;
    }

    // -----------------------------------
   
    public String getSigla ( ) {
        return sigla;
    }

    public void setSigla (String sigla) {
        this.sigla = sigla;
    }

    // -----------------------------------
	
    public Double getCargaHoraria ( ) {
        return cargaHoraria;
    }
	
    public void setCargaHoraria (Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
	
    // ---------------------------------
	
    public String getDescricao ( ) {
        return descricao;
    }
	
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

}

// OK
