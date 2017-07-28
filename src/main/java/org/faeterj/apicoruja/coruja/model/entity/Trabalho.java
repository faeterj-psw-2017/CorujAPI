package org.faeterj.apicoruja.coruja.model.entity;

// import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Table(name="trabalho")
@Entity
public class Trabalho {

    @Column(name="trabalho_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="titulo", nullable=false)
    private String titulo;

    @ManyToOne(optional=false)
    @JoinColumn(name                 ="turma",
                referencedColumnName = "turma_id",
                nullable             = false)
    private Turma turma;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "aluno",
                referencedColumnName = "aluno_id",
                nullable             = false)
    private Aluno aluno;

    // ==============================================

    protected Trabalho ( ) {

    }

    public Trabalho (String titulo) {
        this.titulo = titulo;
    }

    // ==========================================

    public void setId (Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Long getId ( ) {
        return id;
    }

    // ----------------------------------------

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo ( ) {
        return titulo;
    }

    // ------------------------------------------------

    public Aluno getAluno ( ) {
        return aluno;
    }

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    // ------------------------------------

    public Turma getTurma ( ) {
        return turma;
    }

    public void setTurma (Turma turma) {
        this.turma = turma;
    }

}

// OK
