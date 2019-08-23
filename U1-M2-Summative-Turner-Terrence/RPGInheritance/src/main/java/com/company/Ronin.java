package com.company;

public class Ronin extends Shogun {

    private int swords;
    private int armorStrength;
    private int armorDamage;

    public Ronin(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength,
                 int numberOfHelmets, int numberOfFaceShields, String swordType, int weaponStrength, int weaponDexterity, String horseName, int swords, int armorStrength, int armorDamage) {
        super(name, strength, health, stamina, speed, attackPower, shieldStrength, numberOfHelmets, numberOfFaceShields, swordType, weaponStrength, weaponDexterity, horseName);
        this.swords = swords;
        this.armorStrength = armorStrength;
        this.armorDamage = armorDamage;
    }
}
