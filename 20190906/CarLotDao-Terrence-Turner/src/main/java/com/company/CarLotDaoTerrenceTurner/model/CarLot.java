package com.company.CarLotDaoTerrenceTurner.model;

import sun.jvm.hotspot.ui.tree.SimpleTreeGroupNode;

import java.util.Objects;

public class CarLot {

    private int id;
    private String make;
    private String model;
    private String model_year;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return model_year;
    }

    public void setYear(String model_year) {
        this.model_year = model_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLot carLot = (CarLot) o;
        return id == carLot.id &&
                make.equals(carLot.make) &&
                model.equals(carLot.model) &&
                model_year.equals(carLot.model_year) &&
                color.equals(carLot.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, model_year, color);
    }
}
