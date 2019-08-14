package com.company;

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    //constructor
    public CoffeeMaker(String manufacturerIn, String modelIn, int carafeSizeIn, int cupsLeftIn, boolean poweredIn){
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }



    public void brew(){

    }

    public void pourCoffee(int numCups){

    }


}
