package com.trilogyed.circuitbreakerreading;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    /*
     Spring Cloud Netflix Hystrix looks for any method annotated with the @HystrixCommand annotation and wraps that
     method in a proxy connected to a circuit breaker so that Hystrix can monitor it. This currently works only in a
     class marked with @Component or @Service.

     You have applied @HystrixCommand to your original readingList() method. You also have a new method here: reliable().
     The @HystrixCommand annotation has reliable as its fallbackMethod. If, for some reason, Hystrix opens the circuit
     on readingList(), you have an excellent (if short) placeholder reading list ready for your users.

    */

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        URI uri = URI.create("http://localhost:8090/recommended");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
