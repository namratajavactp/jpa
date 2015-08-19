package com.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="Employee_Master")

public class Employee implements Serializable {

	
	private int empId;
	private String name;
	private int sal;
	private Set<Certification> certifications = new HashSet<Certification>();

	public Employee() {
		super();
	}   
	
	
	public Employee(int empId, String name, int sal) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
	}


	@Id
	@Column(name = "empno")
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}   
	@Column(name = "ename")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	@Column(name = "esal")
	public int getSal() {
		return this.sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="emp_certification", joinColumns={@JoinColumn(name="empno")}, inverseJoinColumns={@JoinColumn(name="c_id")})
	public Set<Certification> getCertifications() {
		return certifications;
	}


	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}
	
	public void addCertification(Certification c){
		certifications.add(c);
	}
	
	
   
}
