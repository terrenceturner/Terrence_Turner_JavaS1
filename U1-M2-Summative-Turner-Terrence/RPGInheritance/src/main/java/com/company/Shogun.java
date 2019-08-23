package com.company;

public class Shogun extends Warrior {

    private String swordType;
    private int weaponStrength;
    private int weaponDexterity;
    private String horseName;


    public Shogun(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength,
                  int numberOfHelmets, int numberOfFaceShields, String swordType, int weaponStrength, int weaponDexterity, String horseName) {
        super(name, strength, health, stamina, speed, attackPower, shieldStrength, numberOfHelmets, numberOfFaceShields);
        this.swordType = swordType;
        this.weaponStrength = weaponStrength;
        this.weaponDexterity = weaponDexterity;
        this.horseName = horseName;
    }
}
