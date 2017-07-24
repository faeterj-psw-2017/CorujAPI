package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="calendario")
@Entity
public class Calendario {

	@Id
	@Column(name="calendario_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	// ============================================

	public Calendario (long id) {
		this.id = id;
	}

	protected Calendario ( ) {

	}

	// ============================

	public void setId (long id) {
		this.id = id;
	}

	public long getId ( ) {
		return id;
	}

}

// OK
