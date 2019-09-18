package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
    private static final String INSERT_CONSOLE_SQL = "INSERT INTO console(model, manufacturer, memory_amount, processor, price, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE_SQL = "SELECT * FROM console where console_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL = "SELECT * FROM console";

    private static final String DELETE_CONSOLE_SQL = "DELETE FROM console where console_id = ?";

    private static final String UPDATE_CONSOLE_SQL = "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where console_id = ?";

    private static final String GET_CONSOLE_BY_MANUFACTURER_SQL = "GET * FROM invoice WHERE manufacturer = ?";

    //Method Implementation
    @Override
    public Console getConsole(int console_id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_CONSOLE_SQL,
                    this::mapRowToConsole,
                    console_id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(
                SELECT_ALL_CONSOLES_SQL,
                this::mapRowToConsole);
    }

    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(
                INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemory_amount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        console.setConsole_id(id);

        return console;
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(
                UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemory_amount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsole_id());

    }

    @Override
    public void deleteConsole(int console_id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, console_id);


    }

    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        return jdbcTemplate.query(GET_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);    }


    //Row Mapper
    public Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsole_id(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemory_amount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("Quantity"));

        return console;
    }
}
