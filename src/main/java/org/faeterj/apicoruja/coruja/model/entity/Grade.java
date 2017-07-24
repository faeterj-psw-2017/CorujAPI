package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Table(name="grade")
@Entity
public class Grade {

	@Id
	@Column(name="grade_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// ============================================

	protected Grade ( ) {

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
