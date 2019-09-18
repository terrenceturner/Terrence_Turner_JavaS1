package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
    private static final String SELECT_SALES_TAX_RATE_SQL = "SELECT * FROM sales_tax_rate where state = ?";


    //Method Implementation
    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_SALES_TAX_RATE_SQL,
                    this::mapRowToSalesTaxRate,
                    state);
        } catch (EmptyResultDataAccessException e) {

            return null;
        }
    }

    //Row Mapper
    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate sales_tax_rate = new SalesTaxRate();
        sales_tax_rate.setState(rs.getString("state"));
        sales_tax_rate.setRate(rs.getBigDecimal("rate"));


        return sales_tax_rate;
    }
}
