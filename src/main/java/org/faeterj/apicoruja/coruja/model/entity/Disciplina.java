package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="disciplina")
@Entity
public class Disciplina {

    @Column(name="disciplina_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="sigla", nullable=false)
    private String sigla;

    @Column(name="carga_horaria", nullable=false)
    private Double cargaHoraria;

    @Column(name="descricao", nullable=false)
    private String descricao;

    // ==========================================

    public Disciplina ( ) {
    }

    public Disciplina (
        Long   id,       String nome,
        String sigla,    Double cargaHoraria,
        String descricao
    ) {
        this.id           = id;
        this.nome         = nome;
        this.sigla        = sigla;
        this.cargaHoraria = cargaHoraria;
        this.descricao    = descricao;
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

    public void setSigla (String nome) {
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
