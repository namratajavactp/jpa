

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class AddStudents {

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
			tx=em.getTransaction();
	    	tx.begin();
	    	
	    	College c=new College(1,"S.S.P.C");
	    	em.persist(c);
	    	
	    	
	        Student s1=new Student(1,"Atul",1);
	        em.persist(s1);
	        Student s2=new Student(2,"Saurabh",1);
	        em.persist(s2);
	    		    	
	       	em.getTransaction().commit();
	       	em.refresh(c);
	       	College ob=(College)em.find(College.class, new Integer(1));
	       	
	       	Set<String> names=ob.getStudents();
	       	for(String s:names){
	       		System.out.println(s);	
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
