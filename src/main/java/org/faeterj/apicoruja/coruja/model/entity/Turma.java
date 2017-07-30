package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;
import org.faeterj.apicoruja.coruja.controller.requestBody.TurmaRequestBody;

@Entity
@Table(name="turma")
public final class Turma {

    @Id
    @Column(name="turma_id", updatable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="codigo", nullable=false, unique=true)
    private String codigo;

    @Column(name="sala", nullable=false)
    private String sala;

    @Column(name="turno", nullable=false)
    private char turno; // M = Manhã, T = Tarde, N = Noite, D = Diurno

    @Column(name="semestre", nullable=false, updatable=false)
    private char semestre; // A = primeiro, B = segundo

    @Column(name="ano", nullable=false, updatable=false)
    private int ano;
    
    // por alguma razao, a turma pode ter um professor
    // diferente, por exemplo, se acontecer algum
    // acidente com o professor anterior, mas a turma
    // nunca ira mudar de disciplina
    @ManyToOne(optional=false)
    @JoinColumn(name                 = "professor",
                referencedColumnName = "professor_id",
                nullable             = false)
    private Professor professor;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "disciplina",
                referencedColumnName = "disciplina_id",
                nullable             = false,
                updatable            = false)
    private Disciplina disciplina;

    // ==================================================================

    public Turma ( ) {
    	
    }

    public Turma (String codigo, String sala, char turno) {
        this.codigo = codigo;
        this.sala   = sala;
        this.turno  = turno;
    }

    public Turma (
    	String codigo,         String sala,
    	char turno,            Professor professor,
    	Disciplina disciplina
    ) {
    	this (codigo, sala, turno);

    	this.professor  = professor;
    	this.disciplina = disciplina;
    }
    
    public Turma (TurmaRequestBody requestBody) {
    	this (
    		requestBody.codigo,
    		requestBody.sala,
    		requestBody.turno,
    		new Professor (requestBody.professor),
    		new Disciplina (requestBody.disciplina)
    	);
    }
    
    // ====================================================================

	public Long getId ( ) {
        return id;
	}
	
	public void setId (Long id) {
        this.id = id;
	}

	// ---------------------------------------------------
	
	public String getCodigo ( ) {
        return codigo;
	}
	
	public void setCodigo (String codigo) {
        this.codigo = codigo;
	}

	// ---------------------------------------------------
	
	public String getSala ( ) {
        return sala;
	}
	
	public void setSala (String sala) {
        this.sala = sala;
	}

	// ---------------------------------------------------

	public char getTurno ( ) {
        return turno;
	}
	
	public void setTurno (char turno) {
        this.turno = turno;
	}

    // --------------------------------------------

    // @JsonIgnore
	public Professor getProfessor ( ) {
        return professor;
	}

	public void setProfessor (Professor professor) {
        this.professor = professor;
	}

    // -------------------------------------------------

    // @JsonIgnore
    public Disciplina getDisciplina ( ) {
        return disciplina;
    }

    public void setDisciplina (Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    // ------------------------------------------------------
    
	public char getSemestre ( ) {
		return semestre;
	}

	public void setSemestre (char semestre) {
		this.semestre = semestre;
	}

	// ------------------------------------------------------------
	
	public int getAno ( ) {
		return ano;
	}

	public void setAno (int ano) {
		this.ano = ano;
	}

}

// OK