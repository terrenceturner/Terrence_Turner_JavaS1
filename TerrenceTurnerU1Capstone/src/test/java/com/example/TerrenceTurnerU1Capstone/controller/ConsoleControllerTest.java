package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.dto.Console;
import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.ConsoleViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleControllerTest.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    public void getConsoleByIdShouldReturnConsoleWithIdJson() throws Exception{
        ConsoleViewModel console = new ConsoleViewModel();
        console.setConsole_id(1);
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);

        Optional<ConsoleViewModel> returnVal = Optional.of(console);
        String outputJson = mapper.writeValueAsString(console);
        when(service.findConsole(1)).thenReturn(returnVal.get());

        this.mockMvc.perform(get("/console/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleThatDoesNotExistReturns404() throws Exception {

        // Since findById returns an Optional, we create one. But this time without a value
        // as that would be the expected behavior if we searched for a non-existant id
        Optional<ConsoleViewModel> returnVal = Optional.empty();

        int idForConsoleThatDoesNotExist = 100;

        when(service.findConsole(idForConsoleThatDoesNotExist)).thenReturn(returnVal.get());

        this.mockMvc.perform(get("/console" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createConsoleShouldReturnCreatedConsole() throws Exception {

        ConsoleViewModel inputConsole = new ConsoleViewModel();
        inputConsole.setModel("X123");
        inputConsole.setManufacturer("microsoft");
        inputConsole.setMemory_amount("16GB");
        inputConsole.setProcessor("AMD");
        inputConsole.setPrice(new BigDecimal("450.00"));
        inputConsole.setQuantity(2);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputConsole);

        ConsoleViewModel outputConsole = new ConsoleViewModel();
        outputConsole.setModel("X123");
        outputConsole.setManufacturer("microsoft");
        outputConsole.setMemory_amount("16GB");
        outputConsole.setProcessor("AMD");
        outputConsole.setPrice(new BigDecimal("450.00"));
        outputConsole.setQuantity(2);
        outputConsole.setConsole_id(1);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputConsole);

        when(service.saveConsole(inputConsole)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsolesShouldReturnAListOfConsoles() throws Exception {

        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console.setConsole_id(1);

        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("SSX123");
        console2.setManufacturer("sony");
        console2.setMemory_amount("1GB");
        console2.setProcessor("ROX");
        console2.setPrice(new BigDecimal("500.00"));
        console2.setQuantity(9);
        console2.setConsole_id(2);

        List<ConsoleViewModel> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        //Object to JSON in String
        when(service.findAllConsoles()).thenReturn(consoleList);

        List<ConsoleViewModel> listChecker = new ArrayList<>();
        listChecker.addAll(consoleList);
        //To confirm the test is testing what we think it is... add another Console.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Console(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void getConsoleByManufacturer() {

        ConsoleViewModel console = new ConsoleViewModel();

        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console.setConsole_id(1);

        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("SSX123");
        console2.setManufacturer("sony");
        console2.setMemory_amount("1GB");
        console2.setProcessor("ROX");
        console2.setPrice(new BigDecimal("500.00"));
        console2.setQuantity(9);
        console2.setConsole_id(2);

        List<ConsoleViewModel> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        when(service.findConsoleByManufacturer("microsoft")).thenReturn(consoleList);

        List<ConsoleViewModel> consoleList2 = new ArrayList<>();

        consoleList2.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(consoleList2);

        this.mockMvc.perform(get("/console/manufacturer/microsoft"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));



    }

    @Test
    public void updateConsoleShouldReturnAnUpdatedConsoles() throws Exception {

        Console console = new Console();
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console.setConsole_id(1);

        //these will be the same
        String inputJson = mapper.writeValueAsString(console);
        String outputJson = mapper.writeValueAsString(console);

        this.mockMvc.perform(put("/console" + console.getConsole_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void deleteConsoleIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }



}