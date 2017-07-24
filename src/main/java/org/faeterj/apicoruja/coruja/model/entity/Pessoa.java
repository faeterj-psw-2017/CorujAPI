package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa {

    @Column(name="nome", nullable=false)
    protected String nome;
    
    @Column(name="telefone", nullable=false)
    protected String telefone;
    
    @Column(name="endereco", nullable=false)
    protected String endereco;

    @Column(name="sexo", nullable=false)
    protected char sexo;

    // ================================================================
    
    protected Pessoa ( ) {
		
    }

    public Pessoa (String nome, String telefone, String endereco) {
        this.nome     = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pessoa (
        String nome, String telefone, String endereco, char sexo
    ) {
        this(nome, telefone, endereco);

        this.sexo = sexo;
    }
 
    // ==============================================================

    public String getNome ( ) {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;

    }

    // ----------------------------------------------
    
    public String getTelefone ( ) {
	return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    // -----------------------------------------

    public char getSexo ( ) {
        return sexo;
    }

    public void setSexo (char sexo) {
        this.sexo = sexo;
    }

    // ----------------------------------------------
	
    public String getEndereco ( ) {
        return endereco;
    }

    public void setEndereco (String endereco) {
	this.endereco = endereco;
    }
    
}

// OK
