package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.dto.TShirt;
import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.TShirtViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtControllerTest.class)
public class TShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getTShirtByIdShouldReturnTShirtWithIdJson() throws Exception{
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        tShirt.setT_shirt_id(1);


        Optional<TShirtViewModel> returnVal = Optional.of(tShirt);

        String outputJson = mapper.writeValueAsString(tShirt);

        when(service.findTShirt(1)).thenReturn(returnVal.get());


        this.mockMvc.perform(get("/tShirt/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtThatDoesNotExistReturns404() throws Exception {

        // Since findById returns an Optional, we create one. But this time without a value
        // as that would be the expected behavior if we searched for a non-existant id
//        Optional<TShirtViewModel> returnVal = Optional.empty();
        TShirtViewModel returnVal = null;

        int idForTShirtThatDoesNotExist = 100;

        when(service.findTShirt(idForTShirtThatDoesNotExist)).thenReturn(returnVal);

        this.mockMvc.perform(get("/tShirt" + idForTShirtThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createTShirtShouldReturnCreatedTShirt() throws Exception {

        TShirtViewModel inputTShirt = new TShirtViewModel();
        inputTShirt.setSize("L");
        inputTShirt.setColor("Black");
        inputTShirt.setDescription("A nice shirt");
        inputTShirt.setPrice(new BigDecimal("34.00"));
        inputTShirt.setQuantity(2);


        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputTShirt);

        TShirtViewModel outputTShirt = new TShirtViewModel();
        outputTShirt.setSize("L");
        outputTShirt.setColor("Black");
        outputTShirt.setDescription("A nice shirt");
        outputTShirt.setPrice(new BigDecimal("34.00"));
        outputTShirt.setQuantity(2);
        outputTShirt.setT_shirt_id(1);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputTShirt);

        when(service.saveTShirt(inputTShirt)).thenReturn(outputTShirt);

        this.mockMvc.perform(post("/tShirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTShirtsShouldReturnAListOfTShirts() throws Exception {

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        tShirt.setT_shirt_id(1);

        TShirtViewModel tShirt2 = new TShirtViewModel();
        tShirt.setSize("XL");
        tShirt.setColor("Grey");
        tShirt.setDescription("An okay shirt");
        tShirt.setPrice(new BigDecimal("24.00"));
        tShirt.setQuantity(3);
        tShirt.setT_shirt_id(2);

        List<TShirtViewModel> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);
        tShirtList.add(tShirt2);

        //Object to JSON in String
        when(service.findAllTshirts()).thenReturn(tShirtList);

        List<TShirtViewModel> listChecker = new ArrayList<>();
        listChecker.addAll(tShirtList);
        //To confirm the test is testing what we think it is... add another TShirt.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new TShirt(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/tShirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtsByColor() throws Exception{

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);


        TShirtViewModel  tShirt2 = new TShirtViewModel();
        tShirt.setSize("XL");
        tShirt.setColor("Grey");
        tShirt.setDescription("An okay shirt");
        tShirt.setPrice(new BigDecimal("24.00"));
        tShirt.setQuantity(3);


        List<TShirtViewModel> listChecker = new ArrayList<>();
        listChecker.add(tShirt);
        listChecker.add(tShirt2);

        when(service.findTShirtByColor("Blue")).thenReturn(listChecker);

        List<TShirtViewModel> listChecker2 = new ArrayList<>();

        listChecker2.addAll(listChecker);

        String outputJson = mapper.writeValueAsString(listChecker2);

        this.mockMvc.perform(get("/tshirt/color/Blue"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));



    }

    @Test
    public void getTShirtsBySize() throws Exception{

        TShirtViewModel  tShirt = new TShirtViewModel();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);


        TShirtViewModel  tShirt2 = new TShirtViewModel();
        tShirt.setSize("XL");
        tShirt.setColor("Grey");
        tShirt.setDescription("An okay shirt");
        tShirt.setPrice(new BigDecimal("24.00"));
        tShirt.setQuantity(3);


        List<TShirtViewModel> listChecker = new ArrayList<>();
        listChecker.add(tShirt);
        listChecker.add(tShirt2);

        when(service.findTShirtByColor("XL")).thenReturn(listChecker);

        List<TShirtViewModel> listChecker2 = new ArrayList<>();

        listChecker2.addAll(listChecker);

        String outputJson = mapper.writeValueAsString(listChecker2);

        this.mockMvc.perform(get("/tshirt/size/XL"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void updateTShirtShouldReturnAnUpdatedTShirts() throws Exception {

        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        tShirt.setT_shirt_id(1);

        //these will be the same
        String inputJson = mapper.writeValueAsString(tShirt);
        String outputJson = mapper.writeValueAsString(tShirt);

        this.mockMvc.perform(put("/tShirt" + tShirt.getT_shirt_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void deleteTShirtIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tShirt/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}