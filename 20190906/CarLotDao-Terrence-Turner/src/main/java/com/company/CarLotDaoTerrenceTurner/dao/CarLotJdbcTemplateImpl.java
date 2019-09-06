package com.company.CarLotDaoTerrenceTurner.dao;

import com.company.CarLotDaoTerrenceTurner.model.CarLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarLotJdbcTemplateImpl implements CarLotDao{
    //Prepared statement strings
    private static final String INSERT_CAR_SQL = "INSERT INTO CAR (MAKE, MODEL, YEAR, COLOR) VALUES(?, ?, ?, ?)";

    private static final String SELECT_CAR_SQL = "select * from car where id = ?";

    private static final String SELECT_ALL_CAR_SQL = "select * from car";

    private static final String DELETE_CAR_SQL = "delete from car where id = ?";

    private static final String UPDATE_CAR_SQL = "update car set make = ?, model = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_CARS_BY_MAKE_SQL = "select * from car where make = ?";

    private static final String SELECT_CARS_BY_COLOR_SQL = "select * from car where color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarLotJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets car by id
     *
     * @param id
     * @return
     */
    @Override
    public CarLot getCar(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException e){
            //if nothing is returned just catch the exception and return null;
            return null;
        }
    }

    /**
     * Gets all cars
     *
     * @return
     */
    @Override
    public List<CarLot> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CAR_SQL, this::mapRowToCar);
    }

    /**
     * Adds all cars
     *
     * @param car
     * @return
     */
    @Override
    @Transactional
    public CarLot addCars(CarLot car) {
        jdbcTemplate.update(INSERT_CAR_SQL, car.getMake(), car.getModel(), car.getYear(),
                car.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        car.setId(id);

        return car;
    }

    /**
     * Updates car
     *
     * @param car
     */
    @Override
    public void updateCar(CarLot car) {
        jdbcTemplate.update(UPDATE_CAR_SQL, car.getMake(), car.getModel(), car.getYear(),
                car.getColor(), car.getId());
    }

    /**
     * Deletes car
     *
     * @param id
     */
    @Override
    public void deleteCars(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    /**
     * Gets list of cars by make
     *
     * @param make
     * @return
     */
    @Override
    public List<CarLot> getCarsByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    /**
     * Gets list of cars by color
     *
     * @param color
     * @return
     */
    @Override
    public List<CarLot> getCarsByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR_SQL, this::mapRowToCar, color);
    }

    /**
     * Maps car table row to Car object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */

    public CarLot mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        CarLot carlot = new CarLot();
        carlot.setId(rs.getInt("id"));
        carlot.setMake(rs.getString("make"));
        carlot.setModel(rs.getString("model"));
        carlot.setYear(rs.getString("year"));
        carlot.setColor(rs.getString("color"));

        return carlot;
    }
}
