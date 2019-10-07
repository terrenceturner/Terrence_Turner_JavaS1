package com.trilogyed.adserver.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class AdserverController {

    private List<String> adList = new ArrayList<>();

    private Random random = new Random();

    public AdserverController() {

        adList.add("Home Equity Loans @ 3.87% APR");
        adList.add("Click HERE to qualify for a new car loan!");
        adList.add("Super Sale on summer clothes!");
        adList.add("Summer Show Blowout!!! 30% to 50% off!!!!");
        adList.add("Get a new phone NOW!");
        adList.add("Alaskan Cruises for as low as $700!");
        adList.add("BOGO large 2 topping pizzas!");
        adList.add("Free installation with the purchase of 100 square feet of carpet!");
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getRandomAd(){

        int whichAd = random.nextInt(8);
        return adList.get(whichAd);
    }


}
