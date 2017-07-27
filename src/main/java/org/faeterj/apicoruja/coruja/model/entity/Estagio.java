package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name="estagio")
@Entity
public class Estagio {

	@Id
	@Column(name="estagio_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

    @ManyToOne(optional=false)
    @JoinColumn(name = "aluno", referencedColumnName="aluno_id")
    private Aluno aluno;

    @Column(name="empresa")
    private String empresa;

    @Column(name="funcao")
    private String funcao;

    @Column(name="dataInicio")
    private Date dataInicio;

    @Column(name="dataFim")
    private Date dataFim;

    @Column(name="horas")
    private float horas;

	// ==============================================

	protected Estagio ( ) {

	}

	public Estagio (long id) {
		this.id = id;
	}

    public Estagio (long id, Aluno aluno, String empresa, String funcao, Date dataInicio ) {
        this(id);
        this.aluno = aluno;
        this.empresa = empresa;
        this.funcao = funcao;
        this.dataInicio = dataInicio;
    }

    public Estagio (long id, Aluno aluno, String empresa, String funcao, Date dataInicio, Date dataFim ) {
        this(id, aluno, empresa, funcao, dataInicio);
        this.dataFim = dataFim;
    }

    public Estagio (long id, Aluno aluno, String empresa, String funcao, Date dataInicio, Date dataFim, float horas ) {
        this(id, aluno, empresa, funcao, dataInicio, dataFim);
        this.horas = horas;
    }

	// ===========================================

	public void setId (long id) {
		this.id = id;
	}

	public long getId ( ) {
		return id;
	}

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno ( ) {
        return aluno;
    }

    public void setEmpresa (String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa ( ) {
        return empresa;
    }

    public void setFuncao (String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao ( ) {
        return funcao;
    }

    public void setDataInicio (Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataInicio ( ) {
        return dataInicio;
    }

    public void setDataFim (Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataFim ( ) {
        return dataFim;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }
}

// OK
