package com.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedParameter {

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
			
			Query qr = em.createQuery("select e.empId, e.name, e.sal from Employee e where e.sal >= :min and e.sal <= :max");
			
			qr.setParameter("min", 20000);
			qr.setParameter("max", 40000);
			List empList = qr.getResultList();
			Iterator it = empList.iterator();
			while(it.hasNext()){
				Object objArr[] = (Object[])it.next();
				System.out.println(objArr[0] + ", " + objArr[1] + ", " + objArr[2]);
			}
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
