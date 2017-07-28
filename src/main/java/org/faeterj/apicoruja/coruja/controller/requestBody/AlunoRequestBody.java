package org.faeterj.apicoruja.coruja.controller.requestBody;

public final class AlunoRequestBody extends PessoaRequestBody {

    public String matricula;

    // ===============================================

    public String getMatricula ( ) {
        return matricula;
    }

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }

}
