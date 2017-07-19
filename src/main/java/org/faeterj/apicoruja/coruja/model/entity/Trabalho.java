package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="trabalho")
@Entity
public class Trabalho {

  @Column(name="trabalho_id")
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @Column(name="titulo")
  private String titulo;

  // ==============================================

  protected Trabalho ( ) {

  }

  public Trabalho (long id, String titulo) {
    this.id     = id;
    this.titulo = titulo;
  }

  // ==========================================

  public void setId (long id) {
    this.id = id;
  }

  public long getId ( ) {
    return id;
  }

  // ----------------------------------------

  public void setTitulo (String titulo) {
    this.titulo = titulo;
  }

  public String getTitulo ( ) {
    return titulo;
  }

}

// OK
