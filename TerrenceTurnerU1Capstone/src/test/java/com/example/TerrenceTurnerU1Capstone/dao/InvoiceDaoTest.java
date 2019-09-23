package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    private InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoice_id()));
    }


    @Test
    public void addGetDeleteInvoice() {

        Invoice invoice = new Invoice();
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


        //add
        invoice = invoiceDao.addInvoice(invoice);

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

        invoice = invoiceDao.addInvoice(invoice);
        //get
        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoice_id());

        assertEquals(invoice,invoice1);
        //delete
        invoiceDao.deleteInvoice(invoice.getInvoice_id());

        Invoice invoice2 = invoiceDao.getInvoice((invoice.getInvoice_id()));

        assertNull(invoice2);
    }

//

    @Test
    public void getAllInvoice() {
        Invoice invoice = new Invoice();
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

        //add
        invoice = invoiceDao.addInvoice(invoice);
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

        //add
        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(2,invoiceList.size());
    }
    @Test
    public void updateInvoice(){
        Invoice invoice = new Invoice();
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
        invoice = invoiceDao.addInvoice(invoice);

        invoice.setQuantity(6);
        invoiceDao.updateInvoice(invoice);
        invoice = invoiceDao.addInvoice(invoice);
        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoice_id());
        assertEquals(invoice1,invoice);

    }
}