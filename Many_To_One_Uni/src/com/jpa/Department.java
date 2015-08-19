package com.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Department
 *
 */
@Entity
@Table(name="Dept")

public class Department implements Serializable {	
	private int deptId;
	private String name;
	
	public Department() {
		super();
	}   
	@Id
	@Column(name="deptno")
	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}   
	@Column(name="dname")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
}
