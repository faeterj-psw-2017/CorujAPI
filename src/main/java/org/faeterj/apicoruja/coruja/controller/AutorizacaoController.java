package org.faeterj.apicoruja.coruja.controller;

import org.faeterj.apicoruja.coruja.controller.requestBody.AutorizacaoRequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//import java.io.jsonwebtoken.Jwts;


/**
 * Created by Rodrigo Sudano on 04-Jul-17.
 */

public class AutorizacaoController
{
    private Long validade;

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public String criarToken (@RequestBody AutorizacaoRequestBody autorizacaoRequestBody)
    {
        String token = "";

        //  Falta resolver o "import java.io.jsonwebtoken.Jwts" para usar este gerador de tokens
        //  token = Jwts.builder()
        //         .setClaims(claims)
        //         .setExpiration(definirDataExpiracao())
        //         .signWith(SignatureAlgorithm.HS512, secret)
        //         .compact();

        return token;
    }

    private Date definirDataExpiracao() {
        return new Date(System.currentTimeMillis() + validade * 1000);
    }
}
