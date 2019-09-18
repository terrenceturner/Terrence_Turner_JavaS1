package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt getTShirt(int tshirt_id);

    List<TShirt> getAllTShirts();

    TShirt addTShirt(TShirt tshirt);

    void updateTShirt(TShirt tshirt);

    void deleteTShirt(int tshirt_id);

    List<TShirt> getTShirtByColor(String color);

    List<TShirt> getTShirtBySize(String size);
}
