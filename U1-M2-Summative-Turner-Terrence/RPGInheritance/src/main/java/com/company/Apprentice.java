package com.company;

public class Apprentice extends Farmer {

    private String animalType;
    private int fieldSize;
    private int buildingSize;
    private int numberOfTools;

    public Apprentice(String name, int strength, int health, int stamina, int speed, int attackPower, String animalType,
                      int fieldSize, int buildingSize, int numberOfTools) {
        super(name, strength, health, stamina, speed, attackPower);
        this.animalType = animalType;
        this.fieldSize = fieldSize;
        this.buildingSize = buildingSize;
        this.numberOfTools = numberOfTools;

    }
}
