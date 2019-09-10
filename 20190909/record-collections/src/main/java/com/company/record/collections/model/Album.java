package com.company.record.collections.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Album {

    private int album_id;
    private String title;
    private int artist_id;
    private LocalDate release_date;
    private int label_id;
    private double list_price;

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getLabel_id() {
        return label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
    }

    public double getPrice() {
        return list_price;
    }

    public void setPrice(double list_price) {
        this.list_price = list_price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return album_id == album.album_id &&
                artist_id == album.artist_id &&
                release_date == album.release_date &&
                label_id == album.label_id &&
                Double.compare(album.list_price, list_price) == 0 &&
                title.equals(album.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album_id, title, artist_id, release_date, label_id, list_price);
    }
}
