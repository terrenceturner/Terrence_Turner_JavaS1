package com.company.citydesignwebservice.controller;

import com.company.citydesignwebservice.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.citydesignwebservice.model.City.cities;

@RestController
public class CityController {

    //Post
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)

    public City createCity(@RequestBody City city){

        cities.add(city);

        return city;
    }

    //Get
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public List<City> getCityList(){


        return cities;

    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public City getCityName(@PathVariable String name){

        City cityName = new City();
        cityName.setName(name);



        return cityName;

    }

    //Delete
    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public void deleteCity(@PathVariable("name") String name){

    }




}
