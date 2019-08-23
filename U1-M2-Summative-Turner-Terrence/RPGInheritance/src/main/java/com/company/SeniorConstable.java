package com.company;

public class SeniorConstable extends JuniorConstable {

    private int weapons;
    private String carType;
    private boolean specOpsGear;


    public SeniorConstable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction,
                           String gear, String flashlight, String weaponType, String weaponPower, int weapons, String carType, boolean specOpsGear) {
        super(name, strength, health, stamina, speed, attackPower, jurisdiction, gear, flashlight, weaponType, weaponPower);
        this.weapons = weapons;
        this.carType = carType;
        this.specOpsGear = specOpsGear;
    }
}
