package com.company;


public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;


    //Getters and Setters
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

    public int getNumSpeakers() {
        return numSpeaker;
    }

    public void setNumSpeakers(int numSpeaker) {
        this.numSpeaker = numSpeaker;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }




    //Constructor
    public Radio(String manufacturerIn, String modelIn, int speakerIn, String stationIn, int volumeIn, boolean poweredIn){
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.numSpeaker = speakerIn;
        this.station = stationIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }


    //Method
    public void togglePower(){

    }

}
