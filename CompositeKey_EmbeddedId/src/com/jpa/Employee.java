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
public class Employee implements Serializable {

	
	private EmployeePK empPk; 
	private int sal;
	

	public Employee() {
		super();
	}

	@EmbeddedId
	public EmployeePK getEmpPk() {
		return empPk;
	}


	public void setEmpPk(EmployeePK empPk) {
		this.empPk = empPk;
	}


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}   
	
	
}
