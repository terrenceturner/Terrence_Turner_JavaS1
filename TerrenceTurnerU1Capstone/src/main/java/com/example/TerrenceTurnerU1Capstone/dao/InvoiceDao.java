package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice getInvoice(int invoice_id);

    List<Invoice> getAllInvoices();

    Invoice addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoice_id);
}
