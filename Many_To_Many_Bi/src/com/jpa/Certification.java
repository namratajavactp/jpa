package com.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

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
	private Set<Employee> employees = new HashSet<Employee>();

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

	@ManyToMany(mappedBy="certifications")
	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee emp){
		employees.add(emp);
	}
   
}
