package com.company.weatherwebservice.controller;

import com.company.weatherwebservice.model.Conditions;
import com.company.weatherwebservice.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class WeatherController {

    //Get
    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)

    @ResponseStatus(value = HttpStatus.OK)

    public Temperature temperature(@PathVariable int zipcode){


        Temperature temperature = new Temperature();
        temperature.setCelsius(26);
        temperature.setFahrenheit(80);

        return temperature;


    }

    //Get
    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)

    @ResponseStatus(value = HttpStatus.OK)

    public Conditions conditions(@PathVariable int zipcode){


        Conditions currentConditions = new Conditions();
        currentConditions.setCelsius(36);
        currentConditions.setFahrenheit(90);
        currentConditions.setWindSpeed(60);
        currentConditions.setWindDirection("North");
        currentConditions.setSkies("Cloudy");
        currentConditions.setPrecipitation("Low");

        return currentConditions;


    }

}
