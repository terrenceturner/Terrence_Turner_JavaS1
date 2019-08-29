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
        temperature.setCelsius(zipcode);
        temperature.setFahrenheit(zipcode);

        return temperature;


    }

    //Get
    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)

    @ResponseStatus(value = HttpStatus.OK)

    public Conditions conditions(@PathVariable int zipcode){


        Conditions conditions = new Conditions();
        conditions.setCelsius(zipcode);
        conditions.setFahrenheit(zipcode);

        return conditions;


    }

}
