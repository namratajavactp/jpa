package com.jpa;

//you should get StaleObjectStateException (OptimisticLocking)
//always rely on read commited guarantees from database
//Automatic versioning in Hibernate prevents lost updates when two concurrent transactions try to 
//commit modifications on the same piece of data

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



//import org.hibernate.*;

public class EmpOptimistic {

	/**
	 * @param args
	 */
	static class FirstThread extends Thread
	{
		EntityManagerFactory emf = null;
		EntityManager em=null;
		
		public void run()
		{
			 
			
			em=emf.createEntityManager();
            EntityTransaction tx=em.getTransaction();
            tx.begin();
			Employee p1=(Employee)em.find(Employee.class, 101);
			System.out.println("inside 1st thread"+p1.getName()+" get sal:"+p1.getSalary());
			
			tx.commit();
			
			em.close();
			
			try
			{
			Thread.sleep(2000);
			}
			catch(Exception e)
			{
				
			}
			
			p1.setName("meena");
		
			EntityManager em1=emf.createEntityManager();
			EntityTransaction tx1 =em1.getTransaction();
			tx1.begin();
			System.out.println("1ST THREAD UPDATE");
			
			em1.merge(p1);
			
			tx1.commit();
			em1.close();
			}
		
		public FirstThread(EntityManagerFactory emf) {
			super();
			this.emf=emf;
		}
	}
	
	static class SecondThread extends Thread
	{
		SecondThread()
		{
			super();
			
		}
		
		
		public void run()
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
			EntityManager em1=emf.createEntityManager();
			  EntityTransaction tx=em1.getTransaction();
			  tx.begin();
			  Employee p1=(Employee)em1.find(Employee.class, 101);
			 
			System.out.println("inside 2nd thread"+p1.getName()+" get sal:"+p1.getSalary());
				
			tx.commit();
			em1.close();
			try
			{
			  Thread.sleep(5000);
			  
			}
			catch(Exception e)
			{
			  e.printStackTrace(); 	
			}
			EntityManager em2=emf.createEntityManager();
			
			 EntityTransaction tx2=em2.getTransaction();
			tx2.begin();
			System.out.println("2ND THREAD UPDATE");
			em2.merge(p1);
			tx2.commit();
			em2.close();
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		new FirstThread(emf).start();
		new SecondThread().start();
	}

}
