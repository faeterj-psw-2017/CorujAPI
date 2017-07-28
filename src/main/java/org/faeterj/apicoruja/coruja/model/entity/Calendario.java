package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Table(name="calendario")
@Entity
public class Calendario {

	@Id
	@Column(name="calendario_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ============================================

	public Calendario ( ) {

    }

	// ============================

	public void setId (Long id) {
		this.id = id;
	}

    @JsonIgnore
	public Long getId ( ) {
		return id;
	}

}

// OK
