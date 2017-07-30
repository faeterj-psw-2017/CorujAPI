package org.faeterj.apicoruja.coruja.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name="calendario")
@Entity
public final class Calendario implements Serializable {

	@Id
	@Column(name="calendario_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ============================================

	public Calendario ( ) {

    }

	// ============================

	public void setId (Long id) {
		this.id = id;
	}

	public Long getId ( ) {
		return id;
	}

}

// OK
