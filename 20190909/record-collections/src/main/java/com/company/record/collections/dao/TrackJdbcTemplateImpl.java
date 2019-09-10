package com.company.record.collections.dao;

import com.company.record.collections.model.Track;
import com.company.record.collections.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrackJdbcTemplateImpl implements TrackDao {

    //Prepared statement strings
    private static final String INSERT_TRACK_SQL = "insert into track (album_id, title, runtime) VALUES(?, ?, ?)";

    private static final String SELECT_TRACK_SQL = "select * from track where track_id = ?";

    private static final String SELECT_ALL_TRACKS_SQL = "select * from track";

    private static final String DELETE_TRACK_SQL = "delete from track where track_id = ?";

    private static final String UPDATE_TRACK_SQL = "update track set album_id = ?, title = ?, runtime = ?  where track_id = ?";

    private static final String  SELECT_TRACKS_BY_ALBUM_SQL = "select * from track where album_id = ?";




    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrackJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets track
     *
     * @param id
     * @return
     */
    @Override
    public Track getTrack(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_TRACK_SQL,
                    this::mapRowToTrack,
                    id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }

    }

    /**
     * Gets all tracks
     *
     * @return
     */
    @Override
    public List<Track> getAllTracks() {
        return jdbcTemplate.query(
                SELECT_ALL_TRACKS_SQL,
                this::mapRowToTrack);

    }

    /**
     * Adds track
     *
     * @param track
     * @return
     */
    @Override
    @Transactional
    public Track addTrack(Track track) {
        jdbcTemplate.update(
                INSERT_TRACK_SQL,
                track.getAlbum_id(),
                track.getTitle(),
                track.getRuntime());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        track.setTrack_id(id);

        return track;

    }

    /**
     * Updates track
     *
     * @param track
     */
    @Override
    public void updateTrack(Track track) {
        jdbcTemplate.update(
                UPDATE_TRACK_SQL,
                track.getAlbum_id(),
                track.getTitle(),
                track.getRuntime(),
                track.getTrack_id());


    }

    /**
     * Deltes track
     *
     * @param id
     */
    @Override
    public void deleteTrack(int id) {
        jdbcTemplate.update(DELETE_TRACK_SQL, id);

    }

    /**
     * Get Tracks by album
     *
     * @param album_id
     * @return
     */
    @Override
    public List<Track> getTracksByAlbum(int album_id) {
        return jdbcTemplate.query(
                SELECT_TRACKS_BY_ALBUM_SQL,
                this::mapRowToTrack,
                album_id);

    }

    public Track mapRowToTrack(ResultSet rs, int rowNum) throws SQLException {
        Track track = new Track();
        track.setTrack_id(rs.getInt("track_id"));
        track.setAlbum_id(rs.getInt("album_id"));
        track.setTitle(rs.getString("instagram"));
        track.setRuntime(rs.getInt("runtime"));

        return track;
    }
}
