import java.util.List;

import net.java.agile.dao.CarDAO;
import net.java.agile.model.Car;

public class AppMain {

	public static void main(String[] args) {
		
		CarDAO carDao = new CarDAO();
		
		/* ---- CREATE Record ----- */
		System.out.println("---- CREATE Record -----");
		
		Car car_1 = new Car("Toyota", "Blue", "Electric");
		carDao.saveCar(car_1);	
		Car car_2 = new Car("Hyundai", "Green", "Petrol");
		carDao.saveCar(car_2);
		Car car_3 = new Car("BMW", "Black", "Diesel");
		carDao.saveCar(car_3);
		Car car_4 = new Car("Honda", "Silver", "Electric");
		carDao.saveCar(car_4);
		
		/* ---- GET List of Record ----- */
		System.out.println("---- GET List of Record -----");
		List<Car> cars = carDao.getAllCar();
		cars.forEach(car1 -> System.out.println(car1.getId() + " - " + car1.getBrandName() + " - " + car1.getColour()));
		
		/* ---- UPDATE Record ----- */
		System.out.println("---- UPDATE Record -----");
		car_2.setColour("Metallic Black");
		carDao.updateCar(car_2);
		
		/* ---- GET A Car Record ----- */
		System.out.println("---- GET A Updated Car Record -----");
		Car updatedCar = carDao.getCarById(car_2.getId());
		System.out.println("Updated Car Record: " + updatedCar.getId() + " - " + updatedCar.getBrandName() + " - " + updatedCar.getColour());
		
		/* ---- DELETE A Car Record ----- */
		System.out.println("---- DELETE A Car Record -----");
		carDao.deleteCar(car_4.getId());

		/* ---- GET List of Record ----- */
		System.out.println("---- GET List of Record -----");
		List<Car> carList = carDao.getAllCar();
		carList.forEach(car1 -> System.out.println(car1.getId() + " - " + car1.getBrandName() + " - " + car1.getColour()));
		
	}
 public String test() {
	 return "Test Passed!!";
 }
}
