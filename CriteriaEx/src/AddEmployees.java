

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddEmployees {

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
			
			tx = em.getTransaction();
			tx.begin();
			
				Employee emp = new Employee(1,"ram",5000);
				em.persist(emp);
				
				Employee emp1 = new Employee(2,"shyam",7000);
				em.persist(emp1);
				
				Employee emp2 = new Employee(3,"sita",5000);
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
