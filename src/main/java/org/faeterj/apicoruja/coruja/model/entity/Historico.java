package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
    @JsonIgnore
	public Long getId ( ) {
        return id;
	}

	public void setId (Long id) {
        this.id = id;
	}

}

// OK
