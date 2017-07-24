package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="turma")
public class Turma {

    @Id
    @Column(name="turma_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="codigo", nullable=false)
    private String codigo;

    @Column(name="sala", nullable=false)
    private String sala;

    @Column(name="turno", nullable=false)
    private char turno; // M = Manhã, T = Tarde, N = Noite, D = Diurno

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "professor",
                referencedColumnName = "professor_id",
                nullable             = false)
    private Professor professor;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "disciplina",
                referencedColumnName = "disciplina_id",
                nullable             = false)
    private Disciplina disciplina;

    // ==================================================================

    protected Turma ( ) {

    }

    public Turma (String codigo, String sala, char turno) {
        this.codigo = codigo;
        this.sala   = sala;
        this.turno  = turno;
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
}

// OK
