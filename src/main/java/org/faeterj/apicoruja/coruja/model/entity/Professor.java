package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="professor")
public final class Professor extends Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="professor_id")
	private Long id;

	@Column(name="matricula", unique=true, nullable=false)
	private String matricula;

	// ====================================================

	public Professor ( ) {

	}

	public Professor (String matricula) {
		this.matricula = matricula;
	}

    public Professor (
        String nome,
        String telefone,  String endereco,
        String matricula
    ) {
        this (matricula);

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
