package com.jpa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SP")
public class SalesPerson extends Employee {
	private int incentives;

	public SalesPerson() {
		// TODO Auto-generated constructor stub
	}

	public SalesPerson(int empId, String name, int sal, int incentives) {
		super(empId, name, sal);
		this.incentives = incentives;
	}

	
	public int getIncentives() {
		return incentives;
	}

	public void setIncentives(int incentives) {
		this.incentives = incentives;
	}
}
