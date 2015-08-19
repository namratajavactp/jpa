package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddEmployee_Table {

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
			
			
			Employee_Table emp = new Employee_Table();
		
			emp.setName("James Gosling");
			emp.setSal(20000);
			
			
			Employee_Table emp1 = new Employee_Table();
			
			emp1.setName("Namrata Gosling");
			emp1.setSal(40000);
			
			Employee_Table emp2 = new Employee_Table();
			
			emp2.setName("Neeta Marathe");
			emp2.setSal(70000);
			
			tx = em.getTransaction();
			tx.begin();
				em.persist(emp);
				em.persist(emp1);
				em.persist(emp2);
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
