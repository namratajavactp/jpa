package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

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
			
			
			Employee e1 = new Employee(1001, "James Gosling", 20000);
			Employee e2 = new Employee(1002, "Gavin King", 30000);
			
			Certification c1 = new Certification("scjp", "Sun Certified Java Programmer");
			Certification c2 = new Certification("scwcd", "Sun Certified Web Component Developer");
			Certification c3 = new Certification("scbcd", "Sun Certified Business Component Developer");
			
			e1.addCertification(c1);
			e1.addCertification(c2);
			
			e2.addCertification(c1);
			e2.addCertification(c3);
			
			tx = em.getTransaction();
			tx.begin();
				em.persist(e1);
				em.persist(e2);
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
