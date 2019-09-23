package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {

    @Autowired
    ServiceLayer service;

    // Get
    @RequestMapping(value = "tshirt/{t_shirt_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable int t_shirt_id){
        return service.findTShirt(t_shirt_id);
    }

    // Get T-Shirt by Color
    @RequestMapping(value = "tshirt/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtByColor(@PathVariable String color){
        return service.findTShirtByColor(color);
    }

    // Get T-Shirt By Size
    @RequestMapping(value = "tshirt/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtBySize(@PathVariable String size){
        return service.findTShirtBySize(size);
    }

    // Get All T-Shirts
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts(){
        return service.findAllTshirts();
    }

    // Post
    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel addTShirt(@RequestBody @Valid TShirtViewModel tShirt){
        return service.saveTShirt(tShirt);
    }

    //Put
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel updateTShirt(@RequestBody @Valid TShirtViewModel tShirt, @PathVariable Integer id){
        if(id!= tShirt.getT_shirt_id()){
            throw new IllegalArgumentException();
        }
        return service.updateTShirt(tShirt);
    }

    //Delete
    @RequestMapping(value = "/tshirt/{t_shirt_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTShirt(@PathVariable int id){
        service.removeTShirt(id);
    }
}
