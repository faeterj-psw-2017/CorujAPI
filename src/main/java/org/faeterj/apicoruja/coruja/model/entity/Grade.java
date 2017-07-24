package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="grade")
@Entity
public class Grade {

	@Id
	@Column(name="grade_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ============================================

	public Grade (long id) {
		this.id = id;
	}

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
