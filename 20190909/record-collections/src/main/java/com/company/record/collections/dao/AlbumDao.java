package com.company.record.collections.dao;

import com.company.record.collections.model.Album;

import java.util.List;

public interface AlbumDao {

    /**
     * Gets album
     * @param id
     * @return
     */
    Album getAlbum(int id);

    /**
     * Gets all albums
     * @return
     */
    List<Album> getAllAlbums();

    /**
     * Adds album
     * @param album
     * @return
     */
    Album addAlbum(Album album);

    /**
     * Updates album
     * @param album
     */
    void updateAlbum(Album album);

    /**
     * Deletes album
     * @param id
     */
    void deleteAlbum(int id);
}
