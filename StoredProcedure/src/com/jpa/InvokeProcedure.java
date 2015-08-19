package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InvokeProcedure {

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
			Query qr = em.createNativeQuery("query_raise_sal");	
			tx = em.getTransaction();
			tx.begin();
			qr.setParameter("empnumber", 1002);
			qr.setParameter("amount", 5000);
				qr.getResultList();
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
