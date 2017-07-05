package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pessoa_id")
	private long id;
	
    @Column(name="nome")
    private String nome;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="endereco")
    private String endereco;
	
    // =================================================
    
	protected Pessoa ( ) {
		
	}
	
    public Pessoa (long id, String nome) {
        this.id   = id;
        this.nome = nome;
    }
    
    // ======================================================
 
    public long getId ( ) {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    // ----------------------------------------------

    public String getNome ( ) {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;

    }

    // ----------------------------------------------
    
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    // ----------------------------------------------
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
}

// OK