package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="disciplina")
@Entity
public class Disciplina {

    @Column(name="disciplina_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="carga_horaria")
    private Double cargaHoraria;

    @Column(name="descricao")
    private String descricao;

    @Column(name="sigla")
    private String sigla;

    // ====================================

    protected Disciplina ( ) {
    }

    public Disciplina (
      long id,             String nome,
      Double cargaHoraria, String descricao
      ,String sigla
    ) {
      this.id           = id;
      this.nome         = nome;
      this.cargaHoraria = cargaHoraria;
      this.descricao    = descricao;
      this.sigla        = sigla;
    }

    // =====================================================================

    public long getId ( ) {
    	return id;
    }

    public void setId (long id) {
    	this.id = id;
    }

    // ---------------------------------
  
    public String getNome ( ) {
	return nome;
    }
	
    public void setNome (String nome) {
	this.nome = nome;
    }

    // ---------------------------------
	
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

// OK
