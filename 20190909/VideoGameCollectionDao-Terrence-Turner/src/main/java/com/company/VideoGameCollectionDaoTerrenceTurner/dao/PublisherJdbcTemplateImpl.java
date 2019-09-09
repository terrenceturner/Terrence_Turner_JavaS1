package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Publisher;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherJdbcTemplateImpl implements PublisherDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, website) values (?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "select * from publisher";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, website = ?";

    private static final String DELETE_PUBLISHER =
            "delete from publisher where publisher_id = ?";

    @Autowired
    public PublisherJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(
                INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        publisher.setPublisher_id(id);

        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this publisher id, return null
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(
                UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite(),
                publisher.getPublisher_id());

    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER, id);

    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setWebsite(rs.getString("website"));



        return publisher;
    }
}
