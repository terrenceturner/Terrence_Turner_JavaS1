package com.company.record.collections.model;

import java.util.Objects;

public class Artist {

    private int artist_id;
    private String name;
    private String instagram;
    private String twitter;

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artist_id == artist.artist_id &&
                name.equals(artist.name) &&
                instagram.equals(artist.instagram) &&
                twitter.equals(artist.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist_id, name, instagram, twitter);
    }
}
