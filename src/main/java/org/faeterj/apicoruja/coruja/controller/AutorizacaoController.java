package org.faeterj.apicoruja.coruja.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo Sudano on 04-Jul-17.
 */

@RestController
public class AutorizacaoController
{
    static final String CLAIM_KEY_USUARIO = "usuario";
    static final String CLAIM_KEY_TESTE = "teste";
    static final String CLAIM_KEY_CRIADO = "criado";

    private Long validade = Long.valueOf(1000);

    @RequestMapping(value="/autenticar", method = RequestMethod.POST)
    public String criarToken (String usuario, String senha)
    {
        String token = "";

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USUARIO, usuario);
        claims.put(CLAIM_KEY_TESTE, senha);
        claims.put(CLAIM_KEY_CRIADO, new Date());

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