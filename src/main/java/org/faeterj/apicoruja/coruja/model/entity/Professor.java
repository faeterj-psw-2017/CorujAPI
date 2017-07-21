package org.faeterj.apicoruja.coruja.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor extends Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="professor_id")
	private long id;

	@Column(name="matricula", unique=true)
	private String matricula;
	
	 @OneToMany(mappedBy = "professor", targetEntity = Turma.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private List<Turma> turmas = new ArrayList<Turma>();

	// ==========================================

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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Turma turma) {
		this.turmas.add(turma);
	}

}

// OK