package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="professor")
public final class Professor extends Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="professor_id")
	private long id;

	@Column(name="matricula", unique=true, nullable=false)
	private String matricula;

	// ====================================================

	protected Professor ( ) {

	}

	public Professor (long id, String matricula) {
		this.id        = id;
		this.matricula = matricula;
	}

        public Professor (
                long id,          String nome,
                String telefone,  String endereco,
                String matricula
        ) {
                this (id, matricula);

                this.nome     = nome;
                this.telefone = telefone;
                this.endereco = endereco;
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
