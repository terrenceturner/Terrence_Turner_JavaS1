package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypeJdbcTemplateImpl implements TypeDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_TYPE_SQL =
            "insert into type (name, description) values (?, ?)";

    private static final String SELECT_TYPE_SQL =
            "select * from type where type_id = ?";

    private static final String SELECT_ALL_TYPES_SQL =
            "select * from type";

    private static final String UPDATE_TYPE_SQL =
            "update type set name = ?, website = ?";

    private static final String DELETE_TYPE =
            "delete from type where type_id = ?";

    @Autowired
    public TypeJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Type addType(Type type) {
        jdbcTemplate.update(
                INSERT_TYPE_SQL,
                type.getName(),
                type.getDescription());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        type.setType_id(id);

        return type;
    }

    @Override
    public Type getType(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TYPE_SQL, this::mapRowToType, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this type id, return null
            return null;
        }
    }

    @Override
    public List<Type> getAllTypes() {
        return jdbcTemplate.query(SELECT_ALL_TYPES_SQL, this::mapRowToType);
    }

    @Override
    public void updateType(Type type) {
        jdbcTemplate.update(
                UPDATE_TYPE_SQL,
                type.getName(),
                type.getDescription(),
                type.getType_id());

    }

    @Override
    public void deleteType(int id) {

        jdbcTemplate.update(DELETE_TYPE, id);

    }

    private Type mapRowToType(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();
        type.setType_id(rs.getInt("type_id"));
        type.setName(rs.getString("name"));
        type.setDescription(rs.getString("description"));



        return type;
    }
}
