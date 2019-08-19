package com.company;

public class Constable {
    //properties
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;
    private String jurisdiction;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
        this.jurisdiction = jurisdiction;
    }

    public void run(){

    }

    public void arrest(){

    }

    public void attack(){

    }

    public void heal(){

    }

    public void decreaseHealth(){

    }

    public void increaseStamina(){

    }

    public void decreaseStamina(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
