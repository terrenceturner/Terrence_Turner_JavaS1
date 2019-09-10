package com.company.record.collections.dao;

import com.company.record.collections.model.Track;

import java.util.List;

public interface TrackDao {

    /**
     * Gets track
     * @param id
     * @return
     */
    Track getTrack(int id);

    /**
     * Gets all tracks
     * @return
     */
    List<Track> getAllTracks();

    /**
     * Adds track
     * @param track
     * @return
     */
    Track addTrack(Track track);

    /**
     * Updates track
     * @param track
     */
    void updateTrack(Track track);

    /**
     * Deltes track
     * @param id
     */
    void deleteTrack(int id);

    /**
     * Get Tracks by album
     * @param album_id
     * @return
     */
    List<Track> getTracksByAlbum(int album_id);
}
