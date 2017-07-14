package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

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

    // ====================================

    protected Disciplina ( ) {
    }

    public Disciplina (long id, String nome, Double cargaHoraria, String descricao) {
      this.id           = id;
      this.nome         = nome;
      this.cargaHoraria = cargaHoraria;
      this.descricao    = descricao;
    }

    // =================================================================================

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

}

// OK