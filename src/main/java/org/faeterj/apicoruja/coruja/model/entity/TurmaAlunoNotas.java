package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="turma_aluno_notas")
public class TurmaAlunoNotas {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="turma_aluno_notas_id")
  private long id;

  // ==============================================

  protected TurmaAlunoNotas ( ) {

  }

  public TurmaAlunoNotas (long id) {
    this.id = id;
  }

  // ==================================

  public void setId (long id) {
    this.id = id;
  }

  public long getId ( ) {
    return id;
  }

}

// OK
