package org.faeterj.apicoruja.coruja.controller;

import io.jsonwebtoken.Jwts;
import org.faeterj.apicoruja.coruja.model.entity.TokenJwt;
import org.faeterj.apicoruja.coruja.model.entity.Usuario;
import org.faeterj.apicoruja.coruja.service.TokenJwtService;
import org.faeterj.apicoruja.coruja.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    static final String CLAIM_KEY_USUARIO = "usu";
    static final String CLAIM_KEY_SENHA = "sen";
    static final String CLAIM_KEY_CRIADO = "cri";

    private UsuarioService usuarioService;
    private TokenJwtService tokenJwtService;

    private Long validade = Long.valueOf(1000);

    @Autowired
    public AutorizacaoController(
            UsuarioService usuarioService,
            TokenJwtService tokenJwtService
    ){
        this.usuarioService = usuarioService;
        this.tokenJwtService = tokenJwtService;
    }

    @RequestMapping(value="/autenticar", method = RequestMethod.POST)
    public String criarToken (String matricula, String senha)

    {
        String tokenCorpo = "";

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
            Date criacao = new Date();
            Date expiracao = definirDataExpiracao();

            tokenCorpo = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(definirDataExpiracao())  //secret
                    //   .signWith(SignatureAlgorithm.HS512, "123")
                    .compact();

            TokenJwt token = new TokenJwt(tokenCorpo, criacao, expiracao, matricula);

            tokenJwtService.setTokenJwt(token);

            // Temporario. Deve retornar uma response "web" padra, com cabecalho, etc
            // e o token no cabecalho
            return tokenCorpo;
        }
    }

    private Date definirDataExpiracao() {
        return new Date(System.currentTimeMillis() + validade * 1000);
    }
}