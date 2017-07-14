package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="turma")
public class Turma {

  @Id
  @Column(name="turma_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @Column(name="codigo")
  private String codigo;

  @Column(name="sala")
  private String sala;

  @Column(name="turno")
  private String turno;

  // ======================================

  protected Turma ( ) {
    
  }

  public Turma (long id, String codigo, String sala, String turno) {
    this.id     = id;
    this.codigo = codigo;
    this.sala   = sala;
    this.turno  = turno;
  }

  // ==========================================
  
	public long getId ( ) {
		return id;
	}
	
	public void setId (long id) {
		this.id = id;
	}

	// ---------------------------------------------------
	
	public String getCodigo ( ) {
		return codigo;
	}
	
	public void setCodigo (String codigo) {
		this.codigo = codigo;
	}

	// ---------------------------------------------------
	
	public String getSala ( ) {
		return sala;
	}
	
	public void setSala (String sala) {
		this.sala = sala;
	}

	// ---------------------------------------------------
	
	public String getTurno ( ) {
		return turno;
	}
	
	public void setTurno (String turno) {
		this.turno = turno;
	}
  
}

// OK