

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Employee
 *
 */


public class EmployeeVo implements Serializable {

	
	private int empId;
	private String name;
	private int sal;
	

	public EmployeeVo() {
		super();
	}   
	
	
	public EmployeeVo(int empId, String name, int sal) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
	}


	
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}   

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   

	public int getSal() {
		return this.sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}


	@Override
	public String toString() {
		return empId + ", " + name + ", " + sal;
	}
	
	
   
}
