package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.faeterj.apicoruja.model.embeddable.TurmaAlunosId;

@Entity
@Table(name="turma_aluno_notas")
public class TurmaAlunoNotas {
	
  @EmbeddedId
  private TurmaAlunosId id;
  @Column(nullable=true)
  private Float notaAv1;
  @Column(nullable=true)
  private Float notaAv2;
  @Column(nullable=true)
  private Float notaAvf;

  // ==============================================

  public TurmaAlunoNotas ( ) {

  }

	public String getAlunoNome() {
		return id.getAluno().getNome();
	}
	
	public String getAlunoMatricula(){
		return id.getAluno().getMatricula();
	}
	
	public String getCodigoTurma(){
		return id.getTurma().getCodigo();
	}
	
	public String getNomeProfessor(){
		if(id.getTurma().getProfessor()!=null){
			return id.getTurma().getProfessor().getNome();
		}
		return null;
	}
	
	public TurmaAlunosId getId() {
		return id;
	}
	
	public void setId(TurmaAlunosId id) {
		this.id = id;
	}
	public Float getNotaAv1() {
		return notaAv1;
	}

	public void setNotaAv1(Float notaAv1) {
		this.notaAv1 = notaAv1;
	}
	public Float getNotaAv2() {
		return notaAv2;
	}

	public void setNotaAv2(Float notaAv2) {
		this.notaAv2 = notaAv2;
	}
	public Float getNotaAvf() {
		return notaAvf;
	}

	public void setNotaAvf(Float notaAvf) {
		this.notaAvf = notaAvf;
	}
}

// OK