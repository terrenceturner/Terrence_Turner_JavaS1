package com.company;

public class Farmer extends BaseClass{
    //properties
    private int numberOfCrops;
    private int animals;
    private int equipment;

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower, int numberOfCrops,
                  int animals, int equipment) {
        super(name, strength, health, stamina, speed, attackPower);
        this.numberOfCrops = numberOfCrops;
        this.animals = animals;
        this.equipment = equipment;
    }

    public void plow(){

    }

    public void harvest(){

    }
}
