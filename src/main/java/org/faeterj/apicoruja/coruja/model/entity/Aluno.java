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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="aluno")
public class Aluno extends Pessoa {

  @Id
  @Column(name="aluno_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @OneToOne(optional=true)
  @JoinColumn(name = "historico", referencedColumnName="historico_id") 
  private Historico historico;

  @Column(name="matricula", unique=true)
  private String matricula;
  
  @OneToMany(mappedBy = "id.aluno", targetEntity = TurmaAlunoNotas.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List <TurmaAlunoNotas> turmas;

  // =======================================

  public Aluno ( ) {

  }

  // ==============================

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

  // ------------------------------------

  public Historico getHistorico ( ) {
    return historico;
  }

  public void setHistorico (Historico historico) {
    this.historico = historico;
  }
  
	public List<TurmaAlunoNotas> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(TurmaAlunoNotas turmas) {
		this.turmas.add(turmas);
	}

  	
  
  

}

// OK
