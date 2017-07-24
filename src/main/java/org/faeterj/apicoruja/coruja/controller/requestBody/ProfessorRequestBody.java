package org.faeterj.apicoruja.coruja.controller.requestBody;

public final class ProfessorRequestBody extends PessoaRequestBody {

    public String matricula;

    // =======================================

    public String getMatricula ( ) {
        return matricula;
    }

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }

}

// OK
