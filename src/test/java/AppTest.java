import static org.junit.Assert.*;
 import org.junit.Test;
 
 
 import java.util.List;
 
 import org.hibernate.*;
 import org.hibernate.query.*;
 import org.junit.jupiter.api.*;

import net.java.agile.model.Car;
import net.java.agile.util.CarUtil;
  
 public class AppTest {
	 private static SessionFactory sessionFactory;
	    private Session session;
	     
	    @BeforeAll
	    public static void setup() {
	        sessionFactory = CarUtil.getSessionFactory();
	        System.out.println("SessionFactory created");
	    }
	     
	    @AfterAll
	    public static void tearDown() {
	        if (sessionFactory != null) sessionFactory.close();
	        System.out.println("SessionFactory destroyed");
	    }
	     
	    @Test
	    public void testCreate() {
	    	 System.out.println("Running testCreate...");
	         
	    	    session.beginTransaction();
	    	     
	    	    Car car = new Car("Toyota", "Blue", "Electric");
	    	    Integer id = (Integer) session.save(car);
	    	     
	    	    session.getTransaction().commit();
	    	     
	    	    Assertions.assertTrue(id > 0);
	    }
	     
	    @Test
	    public void testUpdate() {
	    	 AppMain myTest = new AppMain();
	         assertEquals("Test Passed!!", myTest.test());
	    }
	     
	    @Test
	    public void testGet() {
	    	 AppMain myTest = new AppMain();
	         assertEquals("Test Passed!!", myTest.test());
	    }
	     
	    @Test
	    public void testList() {
	    	 AppMain myTest = new AppMain();
	         assertEquals("Test Passed!!", myTest.test());
	    }
	     
	    @Test
	    public void testDelete() {
	    	 AppMain myTest = new AppMain();
	         assertEquals("Test Passed!!", myTest.test());
	    }  
	     
	    @BeforeEach
	    public void openSession() {
	        session = sessionFactory.openSession();
	        System.out.println("Session created");
	    }
	     
	    @AfterEach
	    public void closeSession() {
	        if (session != null) session.close();
	        System.out.println("Session closed\n");
	    }  
 }

	 
    /*@Test
    public void test() {
        AppMain myTest = new AppMain();
        assertEquals("Test Passed!!", myTest.test());
    }
}*/

