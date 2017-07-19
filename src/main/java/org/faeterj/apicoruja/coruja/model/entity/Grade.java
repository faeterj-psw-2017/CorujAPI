package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.*;

@Table(name="grade")
@Entity
public class Grade {

	@Id
	@Column(name="grade_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	// ============================================

	public Grade (long id) {
		this.id = id;
	}

	protected Grade ( ) {

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
