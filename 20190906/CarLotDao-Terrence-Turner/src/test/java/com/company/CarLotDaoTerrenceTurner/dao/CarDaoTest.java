package com.company.CarLotDaoTerrenceTurner.dao;

import com.company.CarLotDaoTerrenceTurner.model.Car;
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
public class CarDaoTest {

    @Autowired
    protected CarDao dao;

    @Before
    public void setUp() throws Exception {
        List<Car> carList = dao.getAllCars();
        carList.stream()
                .forEach(car -> dao.deleteCars(car.getId()));

    }

    @Test
    public void addGetDeleteCar() {

        Car car = new Car();
        car.setMake("Ford");
        car.setModel("F-150");
        car.setYear("2002");
        car.setColor("red");

        car = dao.addCars(car);
        Car car1 = dao.getCar(car.getId());

        assertEquals(car, car1);

        //delete
        dao.deleteCars(car.getId());

        car1 = dao.getCar(car.getId());
        assertNull(car1);
    }

    @Test
    public void getAllCars(){
        Car car = new Car();
        car.setMake("Dodge");
        car.setModel("Stratus");
        car.setYear("2006");
        car.setColor("blue");

        dao.addCars(car);

        car = new Car();
        car.setMake("Nissan");
        car.setModel("Altima");
        car.setYear("2012");
        car.setColor("white");

        dao.addCars(car);

        List<Car> carList = dao.getAllCars();

        assertEquals(2, carList.size());

    }

    @Test
    public void updateCar(){
        Car car = new Car();
        car.setMake("Dodge");
        car.setModel("Stratus");
        car.setYear("2006");
        car.setColor("blue");

        dao.addCars(car);

        car = new Car();
        car.setMake("Nissan");
        car.setModel("Altima");
        car.setYear("2012");
        car.setColor("white");

        dao.updateCar(car);

        Car car1 = dao.getCar(car.getId());
        assertEquals(car, car1);

    }

    @Test
    public void getCarsByMake(){

        Car car = new Car();
        car.setMake("Ford");
        car.setModel("F-150");
        car.setYear("2002");
        car.setColor("red");

        dao.addCars(car);

        car = new Car();
        car.setMake("Dodge");
        car.setModel("Stratus");
        car.setYear("2006");
        car.setColor("blue");

        dao.addCars(car);

        car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2019");
        car.setColor("blue");

        dao.updateCar(car);

        List<Car> carList = dao.getCarsByMake("Ford");
        assertEquals(2, carList.size());

    }

    @Test
    public void getCarsByColor(){
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("F-150");
        car.setYear("2002");
        car.setColor("blue");

        dao.addCars(car);

        car = new Car();
        car.setMake("Dodge");
        car.setModel("Stratus");
        car.setYear("2006");
        car.setColor("blue");

        dao.addCars(car);

        car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear("2019");
        car.setColor("blue");

        dao.updateCar(car);

        List<Car> carList = dao.getCarsByColor("blue");
        assertEquals(3, carList.size());

    }
}