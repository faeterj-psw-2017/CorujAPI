package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="estagio")
@Entity
public class Estagio {

	@Id
	@Column(name="estagio_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ==============================================

	protected Estagio ( ) {

	}

	// ===========================================

	public void setId (Long id) {
		this.id = id;
	}

	public Long getId ( ) {
		return id;
	}

}

// OK
