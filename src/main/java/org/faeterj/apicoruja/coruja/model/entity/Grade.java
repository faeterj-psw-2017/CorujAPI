package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="grade")
@Entity
public final class Grade {

	@Id
	@Column(name="grade_id", updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ============================================

	protected Grade ( ) {

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
