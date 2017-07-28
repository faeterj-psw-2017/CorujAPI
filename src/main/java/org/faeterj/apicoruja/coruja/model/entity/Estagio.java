package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import org.faeterj.apicoruja.coruja.controller.requestBody.EstagioRequestBody;

import java.util.Date;

@Table(name="estagio")
@Entity
public class Estagio {

	@Id
	@Column(name="estagio_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="aluno", referencedColumnName="aluno_id", nullable=false)
    private Aluno aluno;

    @Column(name="empresa", nullable=false)
    private String empresa;

    @Column(name="funcao", nullable=false)
    private String funcao;

    @Column(name="data_inicio", nullable=false)
    private Date dataInicio;

    @Column(name="data_fim")
    private Date dataFim;

    @Column(name="horas")
    private float horas;

    @Column(name="cancelado")
    private boolean cancelado;

	// ==============================================

	public Estagio ( ) {

	}

    public Estagio (Aluno aluno, String empresa, String funcao, Date dataInicio) {
        this.aluno      = aluno;
        this.empresa    = empresa;
        this.funcao     = funcao;
        this.dataInicio = dataInicio;
        this.cancelado  = false;
    }

    public Estagio (
    	Aluno aluno,   String empresa,
    	String funcao, Date dataInicio,
    	Date dataFim
    ) {
        this(aluno, empresa, funcao, dataInicio);
        this.dataFim = dataFim;
    }

    public Estagio (
    	Aluno aluno,   String empresa,
    	String funcao, Date dataInicio,
    	Date dataFim,  float horas
    ) {
        this(aluno, empresa, funcao, dataInicio, dataFim);
        this.horas = horas;
    }

    public Estagio (EstagioRequestBody requestBody) {
    	this (
    			new Aluno (requestBody.aluno),
    			requestBody.empresa,
    			requestBody.funcao,
    			requestBody.dataInicio,
    			requestBody.dataFim,
    			requestBody.horas
    	);
    }
    
	// ===========================================

	public void setId (Long id) {
		this.id = id;
	}

    @JsonIgnore
	public Long getId ( ) {
		return id;
	}
    
    // -----------------------------------------------

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno ( ) {
        return aluno;
    }

    // ------------------------------------------
    
    public void setEmpresa (String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa ( ) {
        return empresa;
    }

    // ------------------------------------------
    
    public void setFuncao (String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao ( ) {
        return funcao;
    }
    
    // --------------------------------------------------

    public void setDataInicio (Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataInicio ( ) {
        return dataInicio;
    }
    
    // ---------------------------------------------

    public void setDataFim (Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataFim ( ) {
        return dataFim;
    }
    
    // --------------------------------------------

    public float getHoras ( ) {
        return horas;
    }

    public void setHoras (float horas) {
        this.horas = horas;
    }
    
    // --------------------------------------

    public boolean getCancelado ( ) {
    	return cancelado;
    }

    public void setCancelado (boolean cancelado) {
    	this.cancelado = cancelado;
    }
}

// OK
