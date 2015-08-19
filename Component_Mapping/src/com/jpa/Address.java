package com.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	private String city, state;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
