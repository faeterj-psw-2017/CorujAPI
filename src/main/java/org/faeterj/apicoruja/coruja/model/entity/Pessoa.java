package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa {

    @Column(name="nome")
    protected String nome;
    
    @Column(name="telefone")
    protected String telefone;
    
    @Column(name="endereco")
    protected String endereco;

    @Column(name="sexo")
    protected char sexo;

    // =================================================
    
    protected Pessoa ( ) {
		
    }
 
    // ======================================================

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
