package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="historico")
public class Historico {

	@Id
	@Column(name="historico_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	// ===================================================
	
	protected Historico ( ) {
		
	}

	public Historico (long id) {
		super ( );
		this.id = id;
	}

	// ================================================
	
	public long getId ( ) {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}
	
}

// OK
