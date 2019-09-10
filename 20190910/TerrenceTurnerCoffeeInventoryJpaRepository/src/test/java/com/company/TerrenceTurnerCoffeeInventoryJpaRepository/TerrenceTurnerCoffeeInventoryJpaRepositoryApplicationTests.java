package com.company.TerrenceTurnerCoffeeInventoryJpaRepository;

import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dao.CoffeeRepository;
import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dao.RoasterRepository;
import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dto.Roaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TerrenceTurnerCoffeeInventoryJpaRepositoryApplicationTests {

	@Autowired
	CoffeeRepository coffeeRepo;

	@Autowired
	RoasterRepository roasterRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest() {

		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Fodgers");
		roaster.setStreet("122 Main St");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30222");
		roaster.setPhone("404-111-1695");
		roaster.setEmail("fodgers@gmail.com");
		roaster.setNote("Hi");

		roasterRepo.save(roaster);

		Coffee coffee = new Coffee();
		coffee.setRoaster_id(roaster.getRoaster_id());
		coffee.setName("Caramel");
		coffee.setCount(2);
		coffee.setUnit_price(2.4);
		coffee.setDescription("great tasting");
		coffee.setType("ground");

		coffeeRepo.save(coffee);

		List<Coffee> coffeeList = coffeeRepo.findAll();
		assertEquals(1, coffeeList.size());

	}


	@Test
	public void findCoffeeByRoaster(){

		coffeeRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Fodgers");
		roaster.setStreet("122 Main St");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30222");
		roaster.setPhone("404-111-1695");
		roaster.setEmail("fodgers@gmail.com");
		roaster.setNote("Hi");

		roasterRepo.save(roaster);

		Roaster roaster1 = new Roaster();
		roaster.setName("Seattle's Best");
		roaster.setStreet("123 Other St");
		roaster.setCity("Seatlle");
		roaster.setState("WA");
		roaster.setPostal_code("49872");
		roaster.setPhone("774-897-2919");
		roaster.setEmail("seattle@gmail.com");
		roaster.setNote("Bye");

		roasterRepo.save(roaster1);

		Coffee coffee = new Coffee();
		coffee.setRoaster_id(roaster.getRoaster_id());
		coffee.setName("Caramel");
		coffee.setCount(2);
		coffee.setUnit_price(2.4);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Mocha");
		coffee.setCount(8);
		coffee.setUnit_price(2.65);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Jelly Doughnut");
		coffee.setCount(3);
		coffee.setUnit_price(5.89);
		coffee.setDescription("okay tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		List<Coffee> coffees = coffeeRepo.findCoffeeByRoaster("Seattle's Best");
		assertEquals(2, coffees.size());
	}

	@Test
	public void findCoffeeByType(){

		coffeeRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Folgers");
		roaster.setStreet("122 Main St");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30222");
		roaster.setPhone("404-111-1695");
		roaster.setEmail("fodgers@gmail.com");
		roaster.setNote("Hi");

		roasterRepo.save(roaster);

		Roaster roaster1 = new Roaster();
		roaster.setName("Seattle's Best");
		roaster.setStreet("123 Other St");
		roaster.setCity("Seatlle");
		roaster.setState("WA");
		roaster.setPostal_code("49872");
		roaster.setPhone("774-897-2919");
		roaster.setEmail("seattle@gmail.com");
		roaster.setNote("Bye");

		roasterRepo.save(roaster1);

		Coffee coffee = new Coffee();
		coffee.setRoaster_id(roaster.getRoaster_id());
		coffee.setName("Caramel");
		coffee.setCount(2);
		coffee.setUnit_price(2.4);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Mocha");
		coffee.setCount(8);
		coffee.setUnit_price(2.65);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Jelly Doughnut");
		coffee.setCount(3);
		coffee.setUnit_price(5.89);
		coffee.setDescription("okay tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		List<Coffee> coffees = coffeeRepo.findCoffeeByType("ground");
		assertEquals(3, coffees.size());

	}

	@Test
	public void findCoffeeByRoasterAndType(){

		coffeeRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Folgers");
		roaster.setStreet("122 Main St");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30222");
		roaster.setPhone("404-111-1695");
		roaster.setEmail("fodgers@gmail.com");
		roaster.setNote("Hi");

		roasterRepo.save(roaster);

		Roaster roaster1 = new Roaster();
		roaster.setName("Seattle's Best");
		roaster.setStreet("123 Other St");
		roaster.setCity("Seatlle");
		roaster.setState("WA");
		roaster.setPostal_code("49872");
		roaster.setPhone("774-897-2919");
		roaster.setEmail("seattle@gmail.com");
		roaster.setNote("Bye");

		roasterRepo.save(roaster1);

		Coffee coffee = new Coffee();
		coffee.setRoaster_id(roaster.getRoaster_id());
		coffee.setName("Caramel");
		coffee.setCount(2);
		coffee.setUnit_price(2.4);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Mocha");
		coffee.setCount(8);
		coffee.setUnit_price(2.65);
		coffee.setDescription("great tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		coffee = new Coffee();
		coffee.setRoaster_id(roaster1.getRoaster_id());
		coffee.setName("Jelly Doughnut");
		coffee.setCount(3);
		coffee.setUnit_price(5.89);
		coffee.setDescription("okay tasting");
		coffee.setType("ground");
		coffeeRepo.save(coffee);

		List<Coffee> coffees = coffeeRepo.findByRoasterAndType("Folgers", "Caramel");
		assertEquals(1, coffees.size());

	}
}
