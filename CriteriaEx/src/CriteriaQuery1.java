

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.*;

public class CriteriaQuery1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		EntityManager entityManager= emf.createEntityManager();
		
		// Get the criteria builder instance from entity manager
		CriteriaBuilder criteriaBuilder = emf.getCriteriaBuilder();
		
		// Create criteria query and pass the value object which needs to be populated as result
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		
		// Tell to criteria query which tables/entities you want to fetch
	      final Root<Employee> empRoot = criteriaQuery.from(Employee.class);
	      criteriaQuery.select(empRoot);
	      criteriaQuery.where( criteriaBuilder.equal( empRoot.get("sal"), 5000 ) );
	      List<Employee> people = entityManager.createQuery( criteriaQuery ).getResultList();
	      for ( Employee e : people ) {
	    	  
	    	  
	    	  System.out.println(e.getEmpId());
	    	  System.out.println(e.getName());
	    	  System.out.println(e.getSal());
	    	      	  
	    	   }
	      
	      entityManager.close();
	      emf.close();
            
	      
	      
	      /*
	   // Time to define where clause in terms of Predicates
	        // This list will contain all Predicates (where clauses)
	        List criteriaList = new ArrayList();
	        
	        Predicate predicate2= criteriaBuilder.equal(
                    empRoot.get("sal"),5000);
            criteriaList.add(predicate2);
            
            
            Predicate predicate3
            = criteriaBuilder.like(criteriaBuilder.upper(empRoot.get("name")),"M%");
            criteriaList.add(predicate3);  
	     
	      
	      
	      CriteriaQuery<Person> criteria = builder.createQuery( Person.class );
	      Root<Person> personRoot = criteria.from( Person.class );
	      criteria.select( personRoot );
	      criteria.where( builder.equal( personRoot.get( Person_.eyeColor ), "brown" ) );
	      List<Person> people = em.createQuery( criteria ).getResultList();
	      for ( Person person : people ) { ... }  */
            
         

	}

}



