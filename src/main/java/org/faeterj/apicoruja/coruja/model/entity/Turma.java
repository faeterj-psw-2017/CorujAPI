package org.faeterj.apicoruja.coruja.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  
  @ManyToOne
  @JoinColumn(name="professor_id")
  private Professor professor;
  
  @OneToMany(mappedBy = "id.turma", targetEntity = TurmaAlunoNotas.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List <TurmaAlunoNotas> alunos;


  // ======================================

  protected Turma ( ) {
    
  }

  public Turma (String codigo, String sala, String turno) {
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
	@JsonIgnore
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<TurmaAlunoNotas> getAlunos() {
		return alunos;
	}

	public void setAlunos(TurmaAlunoNotas alunos) {
		this.alunos.add(alunos);
	}

	
    
}

// OK