package com.company;

public class Cities {

    String name;
    int population;
    boolean isCapital;

    public Cities(String name, int population, boolean isCapital) {
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCaptial(boolean capital) {
        isCapital = capital;
    }

}
