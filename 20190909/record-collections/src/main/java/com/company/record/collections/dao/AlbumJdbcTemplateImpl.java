package com.company.record.collections.dao;

import com.company.record.collections.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumJdbcTemplateImpl implements AlbumDao {

    //Prepared statement strings
    private static final String INSERT_ALBUM_SQL = "insert into album (title, artist_id, release_date, label_id, list_price) VALUES(?, ?, ?, ?, ?)";

    private static final String SELECT_ALBUM_SQL = "select * from album where album_id = ?";

    private static final String SELECT_ALL_ALBUMS_SQL = "select * from album";

    private static final String DELETE_ALBUM_SQL = "delete from album where album_id = ?";

    private static final String UPDATE_ALBUM_SQL = "update album set title = ?, artist_id = ?, release_date = ?, label_id = ?, list_price = ? where album_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AlbumJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets album
     *
     * @param id
     * @return
     */
    @Override
    public Album getAlbum(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_ALBUM_SQL, this::mapRowToAlbum, id);
        } catch (EmptyResultDataAccessException e){
            //if nothing is returned just catch the exception and return null;
            return null;
        }
    }

    /**
     * Gets all albums
     *
     * @return
     */
    @Override
    public List<Album> getAllAlbums() {
        return jdbcTemplate.query(SELECT_ALL_ALBUMS_SQL, this::mapRowToAlbum);
    }

    /**
     * Adds album
     *
     * @param album
     * @return
     */
    @Override
    @Transactional
    public Album addAlbum(Album album) {
        jdbcTemplate.update(INSERT_ALBUM_SQL, album.getTitle(), album.getArtist_id(), album.getRelease_date(),
                album.getLabel_id(), album.getPrice());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        album.setAlbum_id(id);

        return album;
    }

    /**
     * Updates album
     *
     * @param album
     */
    @Override
    public void updateAlbum(Album album) {
        jdbcTemplate.update(UPDATE_ALBUM_SQL, album.getTitle(), album.getArtist_id(), album.getRelease_date(),
                album.getLabel_id(), album.getPrice(), album.getAlbum_id());

    }

    /**
     * Deletes album
     *
     * @param id
     */
    @Override
    public void deleteAlbum(int id) {
        jdbcTemplate.update(DELETE_ALBUM_SQL, id);

    }

    /**
     * Maps album table row to Album object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Album mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setAlbum_id(rs.getInt("album_id"));
        album.setTitle(rs.getString("title"));
        album.setArtist_id(rs.getInt("artist_id"));
        album.setRelease_date(rs.getDate("release_date").toLocalDate());
        album.setLabel_id(rs.getInt("label_id"));
        album.setPrice(rs.getDouble("list_price"));

        return album;
    }


}
