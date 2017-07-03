package org.faeterj.apicoruja.coruja.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="turma")
public class Turma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="turma_id")
    private long id;

    @Column(name="professor")
    private String professor;

    @Column(name="materia")
    private String materia;

    // =============================================

    protected Turma ( ) {

    }

    // ============================================

    public long getId ( ) {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    // --------------------------------------------

    public String getProfessor ( ) {
        return professor;
    }

    public void setProfessor (String professor) {
        this.professor = professor;
    }

    // ---------------------------------------------

    public String getMateria ( ) {
        return materia;
    }

    public void setMateria (String materia) {
        this.materia = materia;
    }

}
