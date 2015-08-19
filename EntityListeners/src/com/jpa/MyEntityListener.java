package com.jpa;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class MyEntityListener {
	@PrePersist
	public void beforePersist(Object entity){
		System.out.println("Inside prePersist");
	}
	
	@PostPersist
	public void afterPersist(Object entity){
		System.out.println("Inside postPersist");
	}
}
