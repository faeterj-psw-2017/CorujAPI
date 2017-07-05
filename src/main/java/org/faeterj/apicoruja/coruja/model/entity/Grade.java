package org.faeterj.apicoruja.coruja.model.entity;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

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