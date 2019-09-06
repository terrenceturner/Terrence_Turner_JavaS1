package com.company.CarLotDaoTerrenceTurner.dao;

import com.company.CarLotDaoTerrenceTurner.model.Car;

import java.util.List;

public interface CarDao {

    /**
     * Gets car by id
     * @param id
     * @return
     */
    Car getCar(int id);

    /**
     * Gets all cars
     * @return
     */
    List<Car> getAllCars();

    /**
     * Adds all cars
     * @param car
     * @return
     */
    Car addCars(Car car);

    /**
     * Updates car
     * @param car
     */
    void updateCar(Car car);

    /**
     * Deletes car
     * @param id
     */
    void deleteCars(int id);

    /**
     * Gets list of cars by make
     * @param make
     * @return
     */
    List<Car> getCarsByMake(String make);

    /**
     * Gets list of cars by color
     * @param color
     * @return
     */
    List<Car> getCarsByColor(String color);
}
