package com.company;

public class Constable extends BaseClass {
    //properties
    private String jurisdiction;
    private String gear;
    private String flashlight;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction,
                     String gear, String flashlight) {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
        this.gear = gear;
        this.flashlight = flashlight;
    }

    public void arrest(){

    }





}
