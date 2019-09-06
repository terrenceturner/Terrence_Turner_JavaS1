package com.company.CarLotDaoTerrenceTurner.dao;

import com.company.CarLotDaoTerrenceTurner.model.CarLot;

import java.util.List;

public interface CarLotDao {

    /**
     * Gets car by id
     * @param id
     * @return
     */
    CarLot getCar(int id);

    /**
     * Gets all cars
     * @return
     */
    List<CarLot> getAllCars();

    /**
     * Adds all cars
     * @param car
     * @return
     */
    CarLot addCars(CarLot car);

    /**
     * Updates car
     * @param car
     */
    void updateCar(CarLot car);

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
    List<CarLot> getCarsByMake(String make);

    /**
     * Gets list of cars by color
     * @param color
     * @return
     */
    List<CarLot> getCarsByColor(String color);
}
