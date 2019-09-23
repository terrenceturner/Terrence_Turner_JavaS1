package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    private ServiceLayer service;

    // Post
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody ConsoleViewModel console) {
        return service.saveConsole(console);
    }

    // Get
    @RequestMapping(value = "/console/{console_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable int console_id){
        return service.findConsole(console_id);
    }

    // Put
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody ConsoleViewModel console){
        service.updateConsole(console);
    }

    // Delete
    @RequestMapping(value = "/console/{console_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int console_id) {
        service.removeConsole(console_id);
    }

    //Get All Consoles
    @RequestMapping(value = "/console")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return service.findAllConsoles();
    }


    //Get Console by Manufacturer
    @RequestMapping(value = "console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        return service.findConsoleByManufacturer(manufacturer);
    }




}
