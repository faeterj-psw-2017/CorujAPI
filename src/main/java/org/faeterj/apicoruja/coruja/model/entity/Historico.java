package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

import org.faeterj.apicoruja.coruja.controller.requestBody.HistoricoRequestBody;

@Entity
@Table(name="historico")
public final class Historico {

	@Id
	@Column(name="historico_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ===================================================
	
	public Historico ( ) {
		
	}

	public Historico (HistoricoRequestBody requestBody) {
		
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
