package com.trilogyed.TerrenceTurnermagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallServiceController {

    // something to hold our answers
    private List<String> answerList = new ArrayList<>();
    // so we can randomly return a answer
    private Random random = new Random();

    public MagicEightBallServiceController() {

        // some answers
        answerList.add("No");
        answerList.add("Yes");
        answerList.add("Looking cloudy");
        answerList.add("Not sure");
        answerList.add("Absolutely!");
        answerList.add("Ask again");
        answerList.add("Umm");
        answerList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getRandomGreeting() {

        // select and return a random answer
        return answerList.get(random.nextInt(8));
    }

}
