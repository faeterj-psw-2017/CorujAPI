package org.faeterj.apicoruja.coruja.controller.requestBody;

public abstract class PessoaRequestBody {

    public String nome;
    public String telefone;
    public String endereco;
    public char   sexo;
    public String cpf;
    public String rg;

    // ========================================================

    public String getNome ( ) {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    // ---------------------------------------------

	public String getTelefone ( ) {
		return telefone;
	}

	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}

    // ----------------------------------------------

	public String getEndereco ( ) {
		return endereco;
	}

	public void setEndereco (String endereco) {
		this.endereco = endereco;
	}

    // ------------------------------------------

	public char getSexo ( ) {
		return sexo;
	}

	public void setSexo (char sexo) {
		this.sexo = sexo;
	}

    // -----------------------------------------

    public String getCpf ( ) {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    // ----------------------------------------------

    public String getRg ( ) {
        return rg;
    }

    public void setRg (String rg) {
        this.rg = rg;
    }

}
