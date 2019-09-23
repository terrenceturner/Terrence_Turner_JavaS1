package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer service;

    // Get
    @RequestMapping(value = "invoice/{invoice_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable int invoice_id){
        return service.findInvoice(invoice_id);
    }

    // Get All Invoices
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices(){
        return service.findAllInvoices();
    }

    // Post
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoice){
        return service.saveInvoice(invoice);
    }
}
