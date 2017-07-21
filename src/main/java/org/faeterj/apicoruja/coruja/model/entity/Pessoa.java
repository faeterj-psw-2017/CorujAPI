package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Table(name="pessoa")
@MappedSuperclass
public abstract class Pessoa {

	 /*
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="pessoa_id")
	 private long id;
	 */
	
	 @Column(name="nome")
	 protected String nome;
	 
	 @Column(name="telefone")
	 protected String telefone;
	 
	 @Column(name="endereco")
	 protected String endereco;
		
	 // =================================================
	 
	 protected Pessoa ( ) {
			
	 }
	
	 /*
	 protected Pessoa (long id) {
	     this.id = id;
	 }
	 */
	
	 /*
	 protected Pessoa (String nome, String telefone, String endereco) {
	     this.nome     = nome;
	     this.telefone = telefone;
	     this.endereco = endereco;
	 }
	 */
	 
	 // ======================================================
	
	 public String getNome ( ) {
	     return nome;
	 }
	
	 public void setNome (String nome) {
	     this.nome = nome;
	
	 }
	
	 // ----------------------------------------------
	 
	 public String getTelefone ( ) {
		return telefone;
	 }
	
	 public void setTelefone (String telefone) {
	     this.telefone = telefone;
	 }
	
	 // ----------------------------------------------
		
	 public String getEndereco ( ) {
	     return endereco;
	 }
	
	 public void setEndereco (String endereco) {
		this.endereco = endereco;
	 }
 
}

// OK
