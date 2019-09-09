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
public class RoasterDaoTest {

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
    public void addGetDeleteRoaster() {

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

        Roaster roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());

        assertEquals(roaster, roaster1);

        roasterDao.deleteRoaster(roaster.getRoaster_id());

        roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());

        assertNull(roaster1);
    }

    @Test
    public void updateRoaster(){

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

        roaster.setNote("Seattle's Best");
        roaster.setNote("Bye");

        roasterDao.updateRoaster(roaster);

        Roaster roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());
        assertEquals(roaster, roaster1);

    }

    @Test
    public void getAllRoasters(){

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

        roaster = new Roaster();
        roaster.setName("Seattle's Best");
        roaster.setStreet("123 Other St");
        roaster.setCity("Seatlle");
        roaster.setState("WA");
        roaster.setPostal_code("49872");
        roaster.setPhone("774-897-2919");
        roaster.setEmail("seattle@gmail.com");
        roaster.setNote("Bye");

        roaster = roasterDao.addRoaster(roaster);

        List<Roaster> roasterList = roasterDao.getAllRoasters();

        assertEquals(2, roasterList.size());

    }
}