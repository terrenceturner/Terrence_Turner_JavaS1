package com.company;


import com.company.interfaces.Vehicle;

public class Accord extends Sedan implements Vehicle {

    private String years;
    private Engine engine;
    private Transmission transmission;


    public Accord() {
        this.years = years;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }




}
