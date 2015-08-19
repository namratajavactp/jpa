package com.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
//@Table(name="Employee_Master")

public class Employee implements Serializable {

	
	private int empId;
	private String name;
	private int sal;
	private Passport passport;

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
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
//	@JoinColumn(name="p_id")
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
   
}
