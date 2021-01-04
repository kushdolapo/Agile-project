import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.*;
import org.junit.jupiter.api.*;

import net.java.agile.model.Car;
import net.java.agile.util.CarUtil;

public class AppTest {
	private static SessionFactory sessionFactory = CarUtil.getSessionFactory();

	private Session session;
	Transaction transaction = null;

	@Test
	public void testCreate() {
		try {
		System.out.println("Running testCreate...");
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		Car car = new Car("Toyota", "Blue", "Electric");
		Long id = (Long) session.save(car);

		transaction.commit();

		Assertions.assertTrue(id > 0);
		//if (session != null)
		}
		catch(Exception e) {
		     if (transaction!=null) transaction.rollback();
		     throw e;
		}
		finally {
			session.close();
		}
			
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
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}
}

/*
 * @Test public void test() { AppMain myTest = new AppMain();
 * assertEquals("Test Passed!!", myTest.test()); } }
 */
