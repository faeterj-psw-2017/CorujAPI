package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Entity
@Table(name="historico")
public class Historico {

	@Id
	@Column(name="historico_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ===================================================
	
	public Historico ( ) {
		
	}

	// ================================================
	
	public Long getId ( ) {
        return id;
	}

	public void setId (Long id) {
        this.id = id;
	}

}

// OK
