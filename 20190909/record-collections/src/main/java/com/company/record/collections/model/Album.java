package com.company.record.collections.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Album {

    private int album_id;
    private String title;
    private int artist_id;
    private LocalDate release_date;
    private int label_id;
    private BigDecimal list_price;

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

    public BigDecimal getPrice() {
        return list_price;
    }

    public void setPrice(BigDecimal list_price) {
        this.list_price = list_price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return album_id == album.album_id &&
                artist_id == album.artist_id &&
                label_id == album.label_id &&
                title.equals(album.title) &&
                release_date.equals(album.release_date) &&
                list_price.equals(album.list_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album_id, title, artist_id, release_date, label_id, list_price);
    }
}
