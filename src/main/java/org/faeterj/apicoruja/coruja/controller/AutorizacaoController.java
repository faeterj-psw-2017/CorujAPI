package org.faeterj.apicoruja.coruja.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.faeterj.apicoruja.coruja.controller.requestBody.AutorizacaoRequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo Sudano on 04-Jul-17.
 */

@RestController
public class AutorizacaoController
{
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";

    private Long validade = Long.valueOf(1000);

    @RequestMapping(value="/autenticar", method = RequestMethod.POST)
    public String criarToken (String usuario, String senha)
    {
        String token = "";

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, usuario);
        claims.put(CLAIM_KEY_AUDIENCE, senha);
        claims.put(CLAIM_KEY_CREATED, new Date());

          token = Jwts.builder()
                 .setClaims(claims)
                 .setExpiration(definirDataExpiracao())  //secret
              //   .signWith(SignatureAlgorithm.HS512, "123")
                 .compact();

        return token;
    }

    private Date definirDataExpiracao() {
        return new Date(System.currentTimeMillis() + validade * 1000);
    }
}
