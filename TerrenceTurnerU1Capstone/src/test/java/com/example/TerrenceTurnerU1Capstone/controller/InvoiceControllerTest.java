package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.dto.Invoice;
import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.InvoiceViewModel;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceControllerTest.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    public void getInvoiceByIdShouldReturnInvoiceWithIdJson() throws Exception{
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("invoice");
        invoice.setStreet("123 Main St");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("72194");
        invoice.setItem_type("itemType");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("3.25"));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal("35.50"));
        invoice.setTax(new BigDecimal("2.30"));
        invoice.setProcessing_fee(new BigDecimal("4.00"));
        invoice.setTotal(new BigDecimal("62.50"));
        invoice.setInvoice_id(1);


        Optional<InvoiceViewModel> returnVal = Optional.of(invoice);

        String outputJson = mapper.writeValueAsString(invoice);

        when(service.findInvoice(1)).thenReturn(returnVal.get());


        this.mockMvc.perform(get("/invoice/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getInvoiceThatDoesNotExistReturns404() throws Exception {

        // Since findById returns an Optional, we create one. But this time without a value
        // as that would be the expected behavior if we searched for a non-existant id
        Optional<InvoiceViewModel> returnVal = Optional.empty();

        int idForInvoiceThatDoesNotExist = 100;

        when(service.findInvoice(idForInvoiceThatDoesNotExist)).thenReturn(returnVal.get());

        this.mockMvc.perform(get("/invoice" + idForInvoiceThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createInvoiceShouldReturnCreatedInvoice() throws Exception {

        InvoiceViewModel inputInvoice = new InvoiceViewModel();
        inputInvoice.setName("invoice");
        inputInvoice.setStreet("123 Main St");
        inputInvoice.setCity("Los Angeles");
        inputInvoice.setState("CA");
        inputInvoice.setZipcode("72194");
        inputInvoice.setItem_type("itemType");
        inputInvoice.setItem_id(2);
        inputInvoice.setUnit_price(new BigDecimal("3.25"));
        inputInvoice.setQuantity(4);
        inputInvoice.setSubtotal(new BigDecimal("35.50"));
        inputInvoice.setTax(new BigDecimal("2.30"));
        inputInvoice.setProcessing_fee(new BigDecimal("4.00"));
        inputInvoice.setTotal(new BigDecimal("62.50"));

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputInvoice);

        InvoiceViewModel outputInvoice = new InvoiceViewModel();
        outputInvoice.setName("invoice");
        outputInvoice.setStreet("123 Main St");
        outputInvoice.setCity("Los Angeles");
        outputInvoice.setState("CA");
        outputInvoice.setZipcode("72194");
        outputInvoice.setItem_type("itemType");
        outputInvoice.setItem_id(2);
        outputInvoice.setUnit_price(new BigDecimal("3.25"));
        outputInvoice.setQuantity(4);
        outputInvoice.setSubtotal(new BigDecimal("35.50"));
        outputInvoice.setTax(new BigDecimal("2.30"));
        outputInvoice.setProcessing_fee(new BigDecimal("4.00"));
        outputInvoice.setTotal(new BigDecimal("62.50"));
        outputInvoice.setInvoice_id(1);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputInvoice);

        when(service.saveInvoice(inputInvoice)).thenReturn(outputInvoice);

        this.mockMvc.perform(post("/invoice")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllInvoicesShouldReturnAListOfInvoices() throws Exception {

        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("invoice");
        invoice.setStreet("123 Main St");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("72194");
        invoice.setItem_type("itemType");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("3.25"));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal("35.50"));
        invoice.setTax(new BigDecimal("2.30"));
        invoice.setProcessing_fee(new BigDecimal("4.00"));
        invoice.setTotal(new BigDecimal("62.50"));
        invoice.setInvoice_id(1);

        InvoiceViewModel invoice2 = new InvoiceViewModel();
        invoice.setName("invoice");
        invoice.setStreet("123 Main St");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("72194");
        invoice.setItem_type("itemType");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("3.25"));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal("35.50"));
        invoice.setTax(new BigDecimal("2.30"));
        invoice.setProcessing_fee(new BigDecimal("4.00"));
        invoice.setTotal(new BigDecimal("62.50"));
        invoice2.setInvoice_id(2);

        List<InvoiceViewModel> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);
        invoiceList.add(invoice2);

        //Object to JSON in String
        when(service.findAllInvoices()).thenReturn(invoiceList);

        List<InvoiceViewModel> listChecker = new ArrayList<>();
        listChecker.addAll(invoiceList);
        //To confirm the test is testing what we think it is... add another Invoice.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Invoice(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}