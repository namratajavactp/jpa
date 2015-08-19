package com.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="Employee_Master")

public class Employee_Table implements Serializable {

	
	private int empId;
	private String name;
	private int sal;
	

	public Employee_Table() {
		super();
	}   
	
	@TableGenerator(name="tg1", table="MyTable")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tg1")
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
   
}
