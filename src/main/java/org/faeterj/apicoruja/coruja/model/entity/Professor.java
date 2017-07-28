package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.faeterj.apicoruja.coruja.controller.requestBody.ProfessorRequestBody;
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

    public Professor (ProfessorRequestBody requestBody) {
        this (
            requestBody.getNome ( ),
            requestBody.getTelefone ( ),
            requestBody.getEndereco ( ),
            requestBody.getMatricula ( )
        );

        this.sexo = requestBody.getSexo ( );
        this.rg   = requestBody.getRg ( );
        this.cpf  = requestBody.getCpf ( );
    }

	// ====================================================

	public void setId (Long id) {
		this.id = id;
	}

    @JsonIgnore
	public Long getId ( ) {
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
