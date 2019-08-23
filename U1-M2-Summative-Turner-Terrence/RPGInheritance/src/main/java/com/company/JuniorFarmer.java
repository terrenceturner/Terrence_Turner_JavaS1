package com.company;

public class JuniorFarmer extends Farmer {

    private String animalType;
    private int fieldSize;
    private int buildingSize;
    private int numberOfTools;

    public JuniorFarmer(String name, int strength, int health, int stamina, int speed, int attackPower, int numberOfCrops,
                        int animals, int equipment, String animalType, int fieldSize, int buildingSize, int numberOfTools) {
        super(name, strength, health, stamina, speed, attackPower, numberOfCrops, animals, equipment);
        this.animalType = animalType;
        this.fieldSize = fieldSize;
        this.buildingSize = buildingSize;
        this.numberOfTools = numberOfTools;
    }
}
