package com.jpa;

import java.sql.Date;

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
			
			Employee emp = new Employee(1001, "James Gosling", 20000);
			SalesPerson sp = new SalesPerson(1002, "Gavin King", 30000, 5000);
			Employee emp1 = new Employee(1003, "James Gosling", 20000);
			SalesPerson sp1 = new SalesPerson(1004, "Gavin King", 30000, 5000);			
			tx = em.getTransaction();
			tx.begin();
				em.persist(emp);
				em.persist(sp);
				em.persist(emp1);
				em.persist(sp1);
			tx.commit();	
			System.out.println("Done!!");
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
