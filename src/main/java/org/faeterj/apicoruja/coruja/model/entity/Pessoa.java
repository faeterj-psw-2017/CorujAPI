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

    @Column (
    	name      = "rg",
    	unique    = true,
    	nullable  = false,
    	updatable = false
    )
    protected String rg;

    @Column (
    	name      = "cpf",
    	unique    = true,
    	nullable  = false,
    	updatable = false
    )
    protected String cpf;

    // ================================================================
    
    public Pessoa ( ) {
		
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

    public Pessoa (
        String nome, String telefone, String endereco, char sexo,
        String rg,   String cpf
    ) {
        this(nome, telefone, endereco, sexo);

        this.rg  = rg;
        this.cpf = cpf;
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
    
    // -------------------------------------------

    public String getRg ( ) {
        return rg;
    }

    public void setRg (String rg) {
        this.rg = rg;
    }

    // ---------------------------------------------

    public String getCpf ( ) {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

}

// OK
