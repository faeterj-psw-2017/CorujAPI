package org.faeterj.apicoruja.coruja.controller;

import io.jsonwebtoken.Jwts;
import org.faeterj.apicoruja.coruja.model.entity.Usuario;
import org.faeterj.apicoruja.coruja.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.SignatureAlgorithm;
import org.faeterj.apicoruja.coruja.controller.requestBody.AutorizacaoRequestBody;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo Sudano on 04-Jul-17.
 */

@RestController
public class AutorizacaoController
{
    static final String CLAIM_KEY_USUARIO = "usu";
    static final String CLAIM_KEY_SENHA = "sen";
    static final String CLAIM_KEY_CRIADO = "cri";


    private UsuarioService usuarioService;

    private Long validade = Long.valueOf(1000);

    @Autowired
    public AutorizacaoController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value="/autenticar", method = RequestMethod.POST)
    public String criarToken (String matricula, String senha)
    {
        String token = "";

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USUARIO, matricula);
        claims.put(CLAIM_KEY_SENHA, senha);
        claims.put(CLAIM_KEY_CRIADO, new Date());

        Usuario usuario = usuarioService.getUsuario(matricula);

        if(usuario == null)
        {
            return "Dados incorretos.";
        }
        else
        {
            token = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(definirDataExpiracao())  //secret
                    //   .signWith(SignatureAlgorithm.HS512, "123")
                    .compact();

            // aqui falta codigo para iniciar o gerenciamento do token
            // depois que fizermos o repositorio de tokens

            return token;
        }
    }

    private Date definirDataExpiracao() {
        return new Date(System.currentTimeMillis() + validade * 1000);
    }
}