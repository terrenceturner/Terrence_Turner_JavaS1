package com.company.TerrenceTurnerCarLotJpaRepository;

import com.company.TerrenceTurnerCarLotJpaRepository.dao.CarRepository;
import com.company.TerrenceTurnerCarLotJpaRepository.dto.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TerrenceTurnerCarLotJpaRepositoryApplicationTests {

	@Autowired
	CarRepository carRepo;


	@Test
	public void contextLoads() {
	}


	@Test
	public void createTest(){

		carRepo.deleteAll();

		Car car = new Car();
		car.setId(111);
		car.setMake("Ford");
		car.setModel("F-150");
		car.setModel_year("2019");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setId(111);
		car.setMake("Dodge");
		car.setModel("Stratus");
		car.setModel_year("2016");
		car.setColor("Blue");
		carRepo.save(car);

		List<Car> carList = carRepo.findAll();
		assertEquals(2, carList.size());

	}

	@Test
	public void findByMake(){

		carRepo.deleteAll();

		Car car = new Car();
		car.setId(111);
		car.setMake("Ford");
		car.setModel("F-150");
		car.setModel_year("2019");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setId(111);
		car.setMake("Dodge");
		car.setModel("Stratus");
		car.setModel_year("2016");
		car.setColor("Blue");
		carRepo.save(car);

		car = new Car();
		car.setId(333);
		car.setMake("Ford");
		car.setModel("Mustang");
		car.setModel_year("2018");
		car.setColor("Blue");

		List<Car> carList = carRepo.findByMake("Ford");

		assertEquals(2, carList.size());

		carList = carRepo.findByMake("Dodge");

		assertEquals(1, carList.size());


	}

	@Test
	public void findByColor(){

		carRepo.deleteAll();

		Car car = new Car();
		car.setId(111);
		car.setMake("Ford");
		car.setModel("F-150");
		car.setModel_year("2019");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setId(111);
		car.setMake("Dodge");
		car.setModel("Stratus");
		car.setModel_year("2016");
		car.setColor("Blue");
		carRepo.save(car);

		car = new Car();
		car.setId(333);
		car.setMake("Ford");
		car.setModel("Mustang");
		car.setModel_year("2018");
		car.setColor("Blue");

		List<Car> carList = carRepo.findByColor("Blue");
		assertEquals(2, carList.size());

		carList = carRepo.findByColor("Red");
		assertEquals(1, carList);


	}

	@Test
	public void findByMakeAndColor(){

		carRepo.deleteAll();

		Car car = new Car();
		car.setId(111);
		car.setMake("Ford");
		car.setModel("F-150");
		car.setModel_year("2019");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setId(111);
		car.setMake("Dodge");
		car.setModel("Stratus");
		car.setModel_year("2016");
		car.setColor("Blue");
		carRepo.save(car);

		car = new Car();
		car.setId(333);
		car.setMake("Ford");
		car.setModel("Mustang");
		car.setModel_year("2018");
		car.setColor("Blue");

		List<Car> carList = carRepo.findByMakeAndColor("Ford", "Red");
		assertEquals(1, carList.size());

	}


}
