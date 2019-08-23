package com.company;

public class MasterFarmer extends JuniorFarmer {

    private String harvesterType;
    private int harvestEfficiency;
    private String tractorType;
    private int tractorEfficiency;


    public MasterFarmer(String name, int strength, int health, int stamina, int speed, int attackPower, int numberOfCrops,
                        int animals, int equipment, String animalType, int fieldSize, int buildingSize, int numberOfTools,
                        String harvesterType, int harvestEfficiency, String tractorType, int tractorEfficiency) {
        super(name, strength, health, stamina, speed, attackPower, numberOfCrops, animals, equipment, animalType, fieldSize, buildingSize, numberOfTools);
        this.harvesterType = harvesterType;
        this.harvestEfficiency = harvestEfficiency;
        this.tractorType = tractorType;
        this.tractorEfficiency = tractorEfficiency;
    }
}
