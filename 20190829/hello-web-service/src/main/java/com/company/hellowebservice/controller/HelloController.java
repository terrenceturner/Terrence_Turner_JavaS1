package com.company.hellowebservice.controller;

import com.company.hellowebservice.model.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //Get
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)

    @ResponseStatus(value = HttpStatus.OK)

    public Hello getGreeting(@PathVariable Hello name){
        return name;
    }
}
