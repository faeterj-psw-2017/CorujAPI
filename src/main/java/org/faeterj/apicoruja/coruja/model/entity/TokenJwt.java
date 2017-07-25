package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rodrigo Sudano on 22-Jul-17.
 */

@Entity
@Table(name="tokenjwt")
public class TokenJwt
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tokenjwt_id")
    private Long id;

    @Column(name="token", unique=true)
    private String token;

    @Column(name="matricula", unique=true)
    private String matricula;

    @Column(name="criacao")
    private Date criacao;

    @Column(name="expiracao")
    private Date expiracao;

    public TokenJwt(String corpo, Date cricao, Date expiracao, String matricula)
    {
        this.token = corpo;
        this.criacao = cricao;
        this.expiracao = expiracao;
        this.matricula = matricula;
    }

    public String getToken(){
        return this.token;
    }
}
