package com.company.CarLotDaoTerrenceTurner.dao;

import com.company.CarLotDaoTerrenceTurner.model.CarLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarLotDaoTest {

    @Autowired
    protected CarLotDao dao;

    @Before
    public void setUp() throws Exception {
        List<CarLot> carLotList = dao.getAllCars();
        carLotList.stream()
                .forEach(carLot -> dao.deleteCars(carLot.getId()));

    }

    @Test
    public void addGetDeleteCar() {

        CarLot carLot = new CarLot();
        carLot.setMake("Ford");
        carLot.setModel("F-150");
        carLot.setYear("2002");
        carLot.setColor("red");

        carLot = dao.addCars(carLot);
        CarLot carLot1 = dao.getCar(carLot.getId());

        assertEquals(carLot, carLot1);

        //delete
        dao.deleteCars(carLot.getId());

        carLot1 = dao.getCar(carLot.getId());
        assertNull(carLot1);
    }

    @Test
    public void getAllCars(){
        CarLot carLot = new CarLot();
        carLot.setMake("Dodge");
        carLot.setModel("Stratus");
        carLot.setYear("2006");
        carLot.setColor("blue");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Nissan");
        carLot.setModel("Altima");
        carLot.setYear("2012");
        carLot.setColor("white");

        dao.addCars(carLot);

        List<CarLot> carLotList = dao.getAllCars();

        assertEquals(2, carLotList.size());

    }

    @Test
    public void updateCar(){
        CarLot carLot = new CarLot();
        carLot.setMake("Dodge");
        carLot.setModel("Stratus");
        carLot.setYear("2006");
        carLot.setColor("blue");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Nissan");
        carLot.setModel("Altima");
        carLot.setYear("2012");
        carLot.setColor("white");

        dao.updateCar(carLot);

        CarLot carLot1 = dao.getCar(carLot.getId());
        assertEquals(carLot, carLot1);

    }

    @Test
    public void getCarsByMake(){

        CarLot carLot = new CarLot();
        carLot.setMake("Ford");
        carLot.setModel("F-150");
        carLot.setYear("2002");
        carLot.setColor("red");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Dodge");
        carLot.setModel("Stratus");
        carLot.setYear("2006");
        carLot.setColor("blue");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Ford");
        carLot.setModel("Mustang");
        carLot.setYear("2019");
        carLot.setColor("blue");

        dao.updateCar(carLot);

        List<CarLot> carLotList = dao.getCarsByMake("Ford");
        assertEquals(2, carLotList.size());

    }

    @Test
    public void getCarsByColor(){
        CarLot carLot = new CarLot();
        carLot.setMake("Ford");
        carLot.setModel("F-150");
        carLot.setYear("2002");
        carLot.setColor("blue");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Dodge");
        carLot.setModel("Stratus");
        carLot.setYear("2006");
        carLot.setColor("blue");

        dao.addCars(carLot);

        carLot = new CarLot();
        carLot.setMake("Ford");
        carLot.setModel("Mustang");
        carLot.setYear("2019");
        carLot.setColor("blue");

        dao.updateCar(carLot);

        List<CarLot> carLotList = dao.getCarsByColor("blue");
        assertEquals(3, carLotList.size());

    }
}