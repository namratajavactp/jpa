package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddEmployee1{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		Employee emp=null;
		
		try {
			emf = Persistence.createEntityManagerFactory("jpa");
			em = emf.createEntityManager();
			
			
						
			tx = em.getTransaction();
		
			tx.begin();
			 emp=(Employee)em.find(Employee.class, 101);
			//	emp.setName("tina");
			tx.commit();	
			System.out.println("Done!!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			em.close();
				}
		
		emp.setName("nisha");
		try {
		
			em = emf.createEntityManager();
			EntityTransaction tx1 =em.getTransaction();
					tx1.begin();	
				Employee emp1=(Employee)em.find(Employee.class, 101);
				
				
			em.merge(emp);
			
			tx1.commit();
			
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
