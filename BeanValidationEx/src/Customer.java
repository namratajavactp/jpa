

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.validation.constraints.*;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="Employee_Master")

public class Customer implements Serializable {

	
	private int empId;
	private String name;
	private int sal;

	@Min(1000)
	@Column(name = "empsal")
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Customer() {
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
	
	 @NotNull
	 @Size(min = 3, max = 80)
	@Column(name = "ename")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	
	
	
	
}
