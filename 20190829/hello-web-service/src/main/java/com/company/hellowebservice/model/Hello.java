package com.company.hellowebservice.model;

import javax.validation.constraints.NotEmpty;

public class Hello {

    @NotEmpty(message = "You must supply a value for greeting")
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
