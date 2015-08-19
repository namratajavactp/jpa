package com.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Certification
 *
 */
@Entity
@Table(name="Certification_Master")
public class Certification implements Serializable {

	
	private String code;
	private String description;
	private static final long serialVersionUID = 1L;

	public Certification() {
		super();
	}   
	
	
	public Certification(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}


	@Id
	@Column(name="id")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="descr")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
