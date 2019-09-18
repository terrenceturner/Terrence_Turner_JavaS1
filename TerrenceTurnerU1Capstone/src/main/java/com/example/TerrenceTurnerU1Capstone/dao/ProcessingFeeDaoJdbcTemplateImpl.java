package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
    private static final String SELECT_PROCESSING_FEE_SQL = "SELECT * FROM processing_fee where product_type = ?";

    //Method Implementation
    @Override
    public ProcessingFee getProcessingFee(String product_type) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_PROCESSING_FEE_SQL,
                    this::mapRowToProcessingFee,
                    product_type);
        } catch (EmptyResultDataAccessException e) {

            return null;
        }
    }

    //Row Mapper
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processing_fee = new ProcessingFee();
        processing_fee.setProduct_type(rs.getString("product_type"));
        processing_fee.setFee(rs.getBigDecimal("fee"));


        return processing_fee;
    }
}
