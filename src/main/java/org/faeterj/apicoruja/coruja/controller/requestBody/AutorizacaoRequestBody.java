package org.faeterj.apicoruja.coruja.controller.requestBody;

/**
 * Created by Rodrigo Sudano on 04-Jul-17.
 */

public class AutorizacaoRequestBody
{
    public String usuario;
    public String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
