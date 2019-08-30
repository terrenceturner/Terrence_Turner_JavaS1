package com.company.dayconverterwebservice.controller;

import com.company.dayconverterwebservice.model.Day;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayController {

    //Get
    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Day getDay(@PathVariable int dayNumber){

        Day currentDay = new Day();
        if (dayNumber < 1 || dayNumber > 7){
            throw new IllegalArgumentException("Input must be between 1 and 7");
        }

        return currentDay;
    }
}
