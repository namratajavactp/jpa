package com.jpa;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Employee_Master")
public class Employee implements Serializable
{


	private int empid;
	
	
	private int version;
	private String name;
	private double salary;
	
	
	@Version
	@Column(name="ver")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Id
	@Column(name = "empno")
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	@Column(name = "ename")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "esal")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
