package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="professor")
public class Professor extends Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="professor_id")
	private long id;

	@Column(name="matricula", unique=true)
	private String matricula;

	// ==========================================

	protected Professor ( ) {

	}

	public Professor (long id, String matricula) {
		this.id        = id;
		this.matricula = matricula;
	}

	// ========================================

	public void setId (long id) {
		this.id = id;
	}

	public long getId ( ) {
		return id;
	}

	// ---------------------------------------------

	public void setMatricula (String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula ( ) {
		return matricula;
	}

}

// OK