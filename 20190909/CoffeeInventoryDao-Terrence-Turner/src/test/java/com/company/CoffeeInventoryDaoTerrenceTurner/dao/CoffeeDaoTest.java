package com.company.CoffeeInventoryDaoTerrenceTurner.dao;

import com.company.CoffeeInventoryDaoTerrenceTurner.model.Coffee;
import com.company.CoffeeInventoryDaoTerrenceTurner.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeDaoTest {

    @Autowired
    CoffeeDao coffeeDao;
    @Autowired
    RoasterDao roasterDao;

    @Before
    public void setUp() throws Exception {
        // Clean out the test db
        List<Coffee> coffeeList = coffeeDao.getAllCoffees();
        for (Coffee c : coffeeList){
            coffeeDao.deleteCoffee(c.getCoffee_id());
        }

        List<Roaster> roasterList = roasterDao.getAllRoasters();
        for (Roaster r : roasterList){
            roasterDao.deleteRoaster(r.getRoaster_id());
        }
    }

    @Test
    public void addGetDeleteCoffee() {
        // Need to create a Coffee and Roaster first

        Roaster roaster = new Roaster();
        roaster.setName("Fodgers");
        roaster.setStreet("122 Main St");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("30222");
        roaster.setPhone("404-111-1695");
        roaster.setEmail("fodgers@gmail.com");
        roaster.setNote("Hi");

        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Caramel");
        coffee.setCount(2);
        coffee.setUnit_price(2.4);
        coffee.setDescription("great tasting");
        coffee.setType("ground");

        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee1 = coffeeDao.getCoffee(coffee.getCoffee_id());

        assertEquals(coffee, coffee1);

        coffeeDao.deleteCoffee(coffee.getCoffee_id());

        coffee = coffeeDao.getCoffee(coffee.getCoffee_id());

        assertNull(coffee);


    }

    @Test
    public void updateCoffee(){

        Roaster roaster = new Roaster();
        roaster.setName("Fodgers");
        roaster.setStreet("122 Main St");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("30222");
        roaster.setPhone("404-111-1695");
        roaster.setEmail("fodgers@gmail.com");
        roaster.setNote("Hi");

        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Caramel");
        coffee.setCount(2);
        coffee.setUnit_price(2.4);
        coffee.setDescription("great tasting");
        coffee.setType("ground");

        coffee = coffeeDao.addCoffee(coffee);

        coffee.setName("Chocolate");
        coffee.setCount(5);

        coffeeDao.updateCoffee(coffee);

        Coffee coffee1 = coffeeDao.getCoffee(coffee.getCoffee_id());

        assertEquals(coffee, coffee1);


    }

    @Test
    public void getAllCoffee(){

        Roaster roaster = new Roaster();
        roaster.setName("Fodgers");
        roaster.setStreet("122 Main St");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("30222");
        roaster.setPhone("404-111-1695");
        roaster.setEmail("fodgers@gmail.com");
        roaster.setNote("Hi");

        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster1 = new Roaster();
        roaster.setName("Seattle's Best");
        roaster.setStreet("123 Other St");
        roaster.setCity("Seatlle");
        roaster.setState("WA");
        roaster.setPostal_code("49872");
        roaster.setPhone("774-897-2919");
        roaster.setEmail("seattle@gmail.com");
        roaster.setNote("Bye");

        roaster1 = roasterDao.addRoaster(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Caramel");
        coffee.setCount(2);
        coffee.setUnit_price(2.4);
        coffee.setDescription("great tasting");
        coffee.setType("ground");

        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Mocha");
        coffee.setCount(8);
        coffee.setUnit_price(2.65);
        coffee.setDescription("great tasting");
        coffee.setType("ground");

        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> coffees = coffeeDao.getAllCoffees();

        assertEquals(2, coffees.size());

    }

    @Test
    public void getCoffeeByRoaster(){

        Roaster roaster = new Roaster();
        roaster.setName("Fodgers");
        roaster.setStreet("122 Main St");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("30222");
        roaster.setPhone("404-111-1695");
        roaster.setEmail("fodgers@gmail.com");
        roaster.setNote("Hi");

        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster1 = new Roaster();
        roaster.setName("Seattle's Best");
        roaster.setStreet("123 Other St");
        roaster.setCity("Seatlle");
        roaster.setState("WA");
        roaster.setPostal_code("49872");
        roaster.setPhone("774-897-2919");
        roaster.setEmail("seattle@gmail.com");
        roaster.setNote("Bye");

        roaster1 = roasterDao.addRoaster(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Caramel");
        coffee.setCount(2);
        coffee.setUnit_price(2.4);
        coffee.setDescription("great tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Mocha");
        coffee.setCount(8);
        coffee.setUnit_price(2.65);
        coffee.setDescription("great tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Jelly Doughnut");
        coffee.setCount(3);
        coffee.setUnit_price(5.89);
        coffee.setDescription("okay tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> coffees = coffeeDao.getCoffeesByRoaster(roaster.getRoaster_id());
        assertEquals(1, coffees.size());

        coffees = coffeeDao.getCoffeesByRoaster(roaster1.getRoaster_id());
        assertEquals(2, coffees.size());


    }

    @Test
    public void getCoffeeByType(){

        Roaster roaster = new Roaster();
        roaster.setName("Fodgers");
        roaster.setStreet("122 Main St");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("30222");
        roaster.setPhone("404-111-1695");
        roaster.setEmail("fodgers@gmail.com");
        roaster.setNote("Hi");

        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster1 = new Roaster();
        roaster.setName("Seattle's Best");
        roaster.setStreet("123 Other St");
        roaster.setCity("Seatlle");
        roaster.setState("WA");
        roaster.setPostal_code("49872");
        roaster.setPhone("774-897-2919");
        roaster.setEmail("seattle@gmail.com");
        roaster.setNote("Bye");

        roaster1 = roasterDao.addRoaster(roaster1);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Caramel");
        coffee.setCount(2);
        coffee.setUnit_price(2.4);
        coffee.setDescription("great tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Mocha");
        coffee.setCount(8);
        coffee.setUnit_price(2.65);
        coffee.setDescription("great tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Jelly Doughnut");
        coffee.setCount(3);
        coffee.setUnit_price(5.89);
        coffee.setDescription("okay tasting");
        coffee.setType("ground");
        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> coffees = coffeeDao.getCoffeesByType("ground");
        assertEquals(3, coffees.size());

    }

}