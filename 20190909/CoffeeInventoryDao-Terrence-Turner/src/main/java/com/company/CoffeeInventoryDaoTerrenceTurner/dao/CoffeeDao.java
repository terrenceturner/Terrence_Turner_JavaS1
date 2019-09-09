package com.company.CoffeeInventoryDaoTerrenceTurner.dao;

import com.company.CoffeeInventoryDaoTerrenceTurner.model.Coffee;

import java.util.List;

public interface CoffeeDao {

    Coffee addCoffee(Coffee coffee);

    Coffee getCoffee(int id);

    List<Coffee> getAllCoffees();

    void updateCoffee(Coffee coffee);

    void deleteCoffee(int id);

    List<Coffee> getCoffeesByRoaster(int roaster_id);

    List<Coffee> getCoffeesByType(String type);

}
