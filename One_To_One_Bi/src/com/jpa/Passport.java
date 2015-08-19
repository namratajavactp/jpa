package com.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Passport
 *
 */
@Entity
@Table(name="Passport_Master")
public class Passport implements Serializable {

	
	private String id;
	private String placeOfIssue;
	private Employee employee;

	public Passport() {
		super();
	}   
	@Id   
	@Column(name="passport_id")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	@Column(name="issue_place")
	public String getPlaceOfIssue() {
		return this.placeOfIssue;
	}

	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}
	
	
	@OneToOne(mappedBy="passport")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
   
}
