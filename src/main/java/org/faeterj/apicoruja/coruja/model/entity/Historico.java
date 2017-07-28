package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import org.faeterj.apicoruja.coruja.controller.requestBody.HistoricoRequestBody;

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

	public Historico (HistoricoRequestBody requestBody) {
		
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
