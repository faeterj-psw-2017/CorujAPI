package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="desempenho")
public final class Desempenho {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="desempenho_id", updatable=false)
    private Long id;

    @Column(name="nota_av1", nullable=true)
    private Double notaAv1;

    @Column(name="nota_av2", nullable=true)
    private Double notaAv2;

    @Column(name="nota_avs", nullable=true)
    private Double notaAvs;

    @Column(name="nota_avf", nullable=true)
    private Double notaAvf;

    @Column(name="segunda_chamada", nullable=true)
    private boolean segundaChamada;

    @Column(name="recuperacao", nullable=true)
    private boolean recuperacao;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "aluno",
                referencedColumnName = "aluno_id",
                nullable             = false)
    private Aluno aluno;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "turma",
                referencedColumnName = "turma_id",
                nullable             = false)
    private Turma turma;

    // ==============================================

    public Desempenho ( ) {

    }

    public Desempenho (Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;

        this.notaAv1 = null;
        this.notaAv2 = null;
        this.notaAvs = null;
        this.notaAvf = null;

        this.segundaChamada = false;
        this.recuperacao    = false;
    }

    // ==================================

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId ( ) {
        return id;
    }

    // ------------------------------------------

    public Double getNotaAv1 ( ) {
		return notaAv1;
	}


	public void setNotaAv1 (Double notaAv1) {
		this.notaAv1 = notaAv1;
	}

    // -----------------------------------------------

	public Double getNotaAv2 ( ) {
		return notaAv2;
	}

	public void setNotaAv2 (Double notaAv2) {
		this.notaAv2 = notaAv2;
	}

    // -------------------------------------------

	public Double getNotaAvf ( ) {
		return notaAvf;
	}

	public void setNotaAvf (Double notaAvf) {
		this.notaAvf = notaAvf;
	}

    // ------------------------------------------

    public Double getNotaAvs ( ) {
        return notaAvs;
    }

    public void setNotaAvs (Double notaAvs) {
        this.notaAvs = notaAvs;
    }

    // -----------------------------------------

    public Aluno getAluno ( ) {
        return aluno;
    }

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    // --------------------------------------

    public Turma getTurma ( ) {
        return turma;
    }

    public void setTurma (Turma turma) {
        this.turma = turma;
    }

    // ---------------------------------------------
    
	public boolean isSegundaChamada ( ) {
		return segundaChamada;
	}

	public void setSegundaChamada (boolean segundaChamada) {
		this.segundaChamada = segundaChamada;
	}

	// -------------------------------------------------------
	
	public boolean isRecuperacao ( ) {
		return recuperacao;
	}

	public void setRecuperacao (boolean recuperacao) {
		this.recuperacao = recuperacao;
	}

	// -----------------------------------------------------

	public double media ( ) {
		if (segundaChamada) {
			if (notaAv1 == null) {
				return (notaAvs + notaAv2) / 2;
			}
			else {
				return (notaAv1 + notaAvs) / 2;
			}
		}

		return (notaAv1 + notaAv2) / 2;
	}
	
	public double mediaFinal ( ) {
		throw new RuntimeException ("Funcionalidade não implementada!");
	}

}

// OK
