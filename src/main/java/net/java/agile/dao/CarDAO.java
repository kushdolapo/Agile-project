package net.java.agile.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.java.agile.model.Car;
import net.java.agile.util.CarUtil;

public class CarDAO {
//save
	public void saveCar(Car car) {
		Transaction transaction = null;
		try(Session session = CarUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(car);
			
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
			
		}
		
	}
	//update
	public void updateCar(Car car) {
		Transaction transaction = null;
		try(Session session = CarUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(car);
			
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
			
		}
		
	}
	//get car
	public Car getCarById(long Id) {
		Transaction transaction = null;
		Car car = null; 
		try(Session session = CarUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			car = session.get(Car.class, Id);
			
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
			
		}
		return car;
		
	}
	//List Car
	@SuppressWarnings("unchecked")
	public List<Car> getAllCar() {
		Transaction transaction = null;
		List<Car> car = null;
		try(Session session = CarUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			car = session.createQuery("from Car").list();
			
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
			
		}
		return car;
		
	}
	public void deleteCar(long Id) {
		Transaction transaction = null;
		Car car = null; 
		try(Session session = CarUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			car = session.get(Car.class, Id);
			
			session.delete(car);
			
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null){
				transaction.rollback();
			}
			
		}
		
	}
}


