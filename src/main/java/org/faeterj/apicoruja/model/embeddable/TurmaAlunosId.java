package org.faeterj.apicoruja.model.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Embeddable
public class TurmaAlunosId implements Serializable  {
	@ManyToOne(fetch = FetchType.LAZY)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	private Turma turma;
	
	@JsonIgnore
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	@JsonIgnore
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
