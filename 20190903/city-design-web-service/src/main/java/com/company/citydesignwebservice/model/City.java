package com.company.citydesignwebservice.model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


public class City {

    @NotEmpty(message = "You must supply a value for name")
    private String name;

    @NotEmpty(message = "You must supply a value for state")
    private String state;

    @NotEmpty(message = "You must supply a value for population")
    private int population;

    public City(@NotEmpty(message = "You must supply a value for name") String name, @NotEmpty(message = "You must supply a value for state")
            String state, @NotEmpty(message = "You must supply a value for population") int population, @NotEmpty(message = "You must supply a value for isCapital") boolean isCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isCapital = isCapital;
    }

    public City(){

    }

    @NotEmpty(message = "You must supply a value for isCapital")


    private boolean isCapital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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


    public static List<City> cities = new ArrayList<>();

    public static List<City> getCities() {
        return cities;
    }

    public static void setCities(List<City> cities) {
        City.cities = cities;
    }


}
