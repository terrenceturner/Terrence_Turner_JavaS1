package com.example.weatherservice.controller;

import com.example.weatherservice.model.Conditions;
import com.example.weatherservice.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WeatherServiceController {

    @RequestMapping(value = "/temp/{zipcode}")
    @ResponseStatus(HttpStatus.OK)
    public Temperature currentTemperature(@PathVariable String zipcode) {

        if (zipcode.length() != 5) {
            throw new IllegalArgumentException("Zipcode must 5 characters long.");
        }

        Random rnd = new Random();
        Temperature temp = new Temperature();
        // Randomly generate a fahrenheit temp between -20 and 120
        temp.setFahrenheit(rnd.nextInt(140) - 20);

        // Convert F to C
        double cTemp = (temp.getFahrenheit() - 32)/1.8;

        temp.setCelsius((int)cTemp);

        return temp;
    }

    @RequestMapping(value = "/conditions/{zipcode}")
    @ResponseStatus(HttpStatus.OK)
    public Conditions currentConditions(@PathVariable String zipcode) {

        if (zipcode.length() != 5) {
            throw new IllegalArgumentException("Zipcode must 5 characters long.");
        }

        Conditions conditions = new Conditions();
        conditions.setFahrenheit(88);
        conditions.setCelsius(31);
        conditions.setPrecipitation("rain");
        conditions.setSkies("cloudy");
        conditions.setWindDirection("north");
        conditions.setWindSpeed(4);

        return conditions;
    }
}
