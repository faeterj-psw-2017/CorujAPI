package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="estagio")
@Entity
public class Estagio {

	@Id
	@Column(name="estagio_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	// ==============================================

	protected Estagio ( ) {

	}

	public Estagio (long id) {
		this.id = id;
	}

	// ===========================================

	public void setId (long id) {
		this.id = id;
	}

	public long getId ( ) {
		return id;
	}

}

// OK
