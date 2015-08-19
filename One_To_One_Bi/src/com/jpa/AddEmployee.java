package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("jpa");
			em = emf.createEntityManager();
			
			Passport passport = new Passport();
			passport.setId("p1");
			passport.setPlaceOfIssue("Mumbai");
			
			Employee emp = new Employee();
			emp.setEmpId(1001);
			emp.setName("James Gosling");
			emp.setSal(20000);
			emp.setPassport(passport);
			passport.setEmployee(emp);
			
			/* although setEmployee method is available in Passport bean class,it will not cause a change in persistent relationship
			 * if we set it.When we marked @OneToOne relationship in Passport bean class with the mappedBy attribute,this designated the
			 * Passport entity as the inverse side of the relationship.This means the Employee side is the owning side of the relationship.
			 * If you wanted to associate a Passport instance with a different Customer you would have to call setPassport() on the old 
			 * customer,passing in null, and then setPassport() on the new Customer
			 * 
			 * Customer cust=new Customer();
			 * Passport p=new Passport();
			 * cust.setCreditCard(p);
			 * p.setCustomer(cust);
			 * entityManager.persist(cust);
			 */
			tx = em.getTransaction();
			tx.begin();
				em.persist(emp);
			tx.commit();	
			System.out.println("Done!!");
			
			
			/*
			 * Customer cust=em.find(Customer.class,id);
			 * em.remove(cust.getCreditCard());
			 * cust.setCreditCard(null);
			 */
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}

	}

}
