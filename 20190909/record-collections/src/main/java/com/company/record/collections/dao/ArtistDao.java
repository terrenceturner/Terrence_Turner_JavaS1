package com.company.record.collections.dao;

import com.company.record.collections.model.Artist;

import java.util.List;

public interface ArtistDao {

    /**
     * Gets artist
     * @param id
     * @return
     */
    Artist getArtist(int id);

    /**
     * Gets all artists
     * @return
     */
    List<Artist> getAllArtist();

    /**
     * Adds artist
     * @param artist
     * @return
     */
    Artist addArtist(Artist artist);

    /**
     * Updates artist
     * @param artist
     */
    void updateArtist(Artist artist);

    /**
     * Deletes id
     * @param id
     */
    void deleteArtist(int id);

}
