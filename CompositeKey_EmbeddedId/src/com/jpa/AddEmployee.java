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
			
			EmployeePK pk = new EmployeePK();
			pk.setEmpId(1001);
			pk.setName("James Gosling");
			
			Employee emp = new Employee();
			emp.setEmpPk(pk);
			emp.setSal(20000);
			
			tx = em.getTransaction();
			tx.begin();
				em.persist(emp);
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
