package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
    private static final String INSERT_TSHIRT_SQL = "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT_SQL = "SELECT * FROM t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL = "SELECT * FROM t_shirt";

    private static final String DELETE_TSHIRT_SQL = "DELETE FROM t_shirt where t_shirt_id = ?";

    private static final String UPDATE_TSHIRT_SQL = "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?, quantity = ?  where t_shirt_id = ?";

    private static final String GET_TSHIRT_BY_COLOR_SQL = "GET * FROM t_shirt WHERE color = ?";

    private static final String GET_TSHIRT_BY_SIZE_SQL = "GET * FROM t_shirt WHERE size = ?";


    //Method Implementations
    @Override
    public TShirt getTShirt(int tshirt_id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_TSHIRT_SQL,
                    this::mapRowToTShirt,
                    tshirt_id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTShirt);
    }

    @Override
    @Transactional
    public TShirt addTShirt(TShirt t_shirt) {
        jdbcTemplate.update(
                INSERT_TSHIRT_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        t_shirt.setT_shirt_id(id);

        return t_shirt;
    }

    @Override
    public void updateTShirt(TShirt t_shirt) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity(),
                t_shirt.getT_shirt_id());

    }

    @Override
    public void deleteTShirt(int tshirt_id) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL, tshirt_id);

    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        return jdbcTemplate.query(GET_TSHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        return jdbcTemplate.query(GET_TSHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }


    //Row Mapper
    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt t_shirt = new TShirt();
        t_shirt.setT_shirt_id(rs.getInt("t_shirt_id"));
        t_shirt.setSize(rs.getString("size"));
        t_shirt.setColor(rs.getString("color"));
        t_shirt.setDescription(rs.getString("description"));
        t_shirt.setPrice(rs.getBigDecimal("price"));
        t_shirt.setQuantity(rs.getInt("quantity"));

        return t_shirt;
    }

}
