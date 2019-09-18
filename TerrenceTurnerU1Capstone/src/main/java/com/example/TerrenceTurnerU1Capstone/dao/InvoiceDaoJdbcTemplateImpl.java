package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    //Prepared Statements
    private static final String INSERT_INVOICE_SQL = "INSERT INTO t_shirt (name, street, city, state, zipcode, item_type, item_id," +
            "unit_price, quantity, subtotal, tax, processing_fee, total) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_INVOICE_SQL = "SELECT * FROM t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL = "SELECT * FROM t_shirt";

    private static final String DELETE_INVOICE_SQL = "DELETE FROM t_shirt where t_shirt_id = ?";

    private static final String UPDATE_INVOICE_SQL = "UPDATE t_shirt SET name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id =?," +
            "unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ?  where t_shirt_id = ?";


    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Methods Implementation
    @Override
    public Invoice getInvoice(int invoice_id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_INVOICE_SQL,
                    this::mapRowToInvoice,
                    invoice_id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(
                INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getUnit_price(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoice.setInvoice_id(id);

        return invoice;
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(
                UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getUnit_price(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal(),
                invoice.getInvoice_id());

    }

    @Override
    public void deleteInvoice(int invoice_id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, invoice_id);


    }

    //Row Mapper
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(rs.getInt("invoice_id"));
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItem_type(rs.getString("item_type"));
        invoice.setItem_id(rs.getInt("item_id"));
        invoice.setUnit_price(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessing_fee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
