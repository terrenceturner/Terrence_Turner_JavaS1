package com.company.weatherwebservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Temperature {

    @NotEmpty(message = "You must supply a value for fahrenheit")
    @Size(min = 1, max = 3, message = "fahrenheit must be 3 characters in length")
    private int fahrenheit;

    @NotEmpty(message = "You must supply a value for celsius")
    @Size(min = 1, max = 2, message = "celsius must be 2 characters in length")
    private int celsius;



    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }
}
