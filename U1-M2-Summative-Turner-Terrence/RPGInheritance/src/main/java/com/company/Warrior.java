package com.company;

public class Warrior extends BaseClass {
    //properties
    private int shieldStrength;
    private int numberOfHelmets;
    private int numberOfFaceShields;


    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength,
                   int numberOfHelmets, int numberOfFaceShields) {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
        this.numberOfHelmets = numberOfHelmets;
        this.numberOfFaceShields = numberOfFaceShields;
    }

    public void heal(){

    }



}
