package com.company;

public class JuniorConstable extends Constable {

    private String weaponType;
    private String weaponPower;


    public JuniorConstable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction,
                           String gear, String flashlight, String weaponType, String weaponPower) {
        super(name, strength, health, stamina, speed, attackPower, jurisdiction, gear, flashlight);
        this.weaponType = weaponType;
        this.weaponPower = weaponPower;
    }
}
