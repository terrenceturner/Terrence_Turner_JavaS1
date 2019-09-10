package com.company.record.collections.dao;

import com.company.record.collections.model.Artist;
import com.company.record.collections.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistJdbcTemplateImpl implements ArtistDao {

    //Prepared statement strings
    private static final String INSERT_ARTIST_SQL = "insert into artist (name, instagram, twitter) VALUES(?, ?, ?)";

    private static final String SELECT_ARTIST_SQL = "select * from artist where artist_id = ?";

    private static final String SELECT_ALL_ARTIST_SQL = "select * from artist";

    private static final String DELETE_ARTIST_SQL = "delete from artist where artist_id = ?";

    private static final String UPDATE_ARTIST_SQL = "update artist set name = ?, instagram = ?, twitter = ? where artist_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ArtistJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets artist
     *
     * @param id
     * @return
     */
    @Override
    public Artist getArtist(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ARTIST_SQL, this::mapRowToArtist, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Artist with this id, just return null
            return null;


        }

    }

        /**
         * Gets all artists
         *
         * @return
         */
        @Override
        public List<Artist> getAllArtist () {
            return jdbcTemplate.query(SELECT_ALL_ARTIST_SQL, this::mapRowToArtist);
        }

        /**
         * Adds artist
         *
         * @param artist
         * @return
         */
        @Override
        @Transactional
        public Artist addArtist (Artist artist){
            jdbcTemplate.update(INSERT_ARTIST_SQL, artist.getName(), artist.getInstagram(), artist.getTwitter());

            int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

            artist.setArtist_id(id);
            return artist;

        }

        /**
         * Updates artist
         *
         * @param artist
         */
        @Override
        public void updateArtist (Artist artist){
            jdbcTemplate.update(UPDATE_ARTIST_SQL, artist.getName(), artist.getInstagram(), artist.getTwitter(), artist.getArtist_id());
        }

        /**
         * Deletes id
         *
         * @param id
         */
        @Override
        public void deleteArtist ( int id){
            jdbcTemplate.update(DELETE_ARTIST_SQL, id);

        }

        public Artist mapRowToArtist (ResultSet rs,int rowNum) throws SQLException {
            Artist artist = new Artist();
            artist.setArtist_id(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            artist.setInstagram(rs.getString("instagram"));
            artist.setTwitter(rs.getString("twitter"));

            return artist;
        }

}
