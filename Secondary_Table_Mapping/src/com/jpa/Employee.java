package com.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="Employee_Master")
@SecondaryTable(name="Employee_Details", pkJoinColumns={@PrimaryKeyJoinColumn(name="empid")})
public class Employee implements Serializable {

	
	private int empId;
	private String name;
	private int sal;
	private Nationality nationality;
	private BloodGroup bloodGroup;
	

	public Employee() {
		super();
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
	
	@Enumerated(EnumType.STRING)
	@Column(table="Employee_Details")
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(table="Employee_Details")
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}   
}
