package com.company.weatherwebservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Conditions {

    @NotEmpty(message = "You must supply a value for fahrenheit")
    @Size(min = 1, max = 3, message = "fahrenheit must be 3 characters in length")
    private Number fahrenheit;

    @NotEmpty(message = "You must supply a value for celsius")
    @Size(min = 1, max = 2, message = "celsius must be 2 characters in length")
    private Number celsius;


    @NotEmpty(message = "You must supply a value for windSpeed")
    private Number windSpeed;

    @NotEmpty(message = "You must supply a value for windDirection")
    private String windDirection;

    @NotEmpty(message = "You must supply a value for skies")
    private String skies;

    @NotEmpty(message = "You must supply a value for precipitation")
    private String precipitation;

    public Number getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Number getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public Number getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
