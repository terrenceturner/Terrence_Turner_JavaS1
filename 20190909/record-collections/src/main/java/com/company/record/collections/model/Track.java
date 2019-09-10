package com.company.record.collections.model;

import java.util.Objects;

public class Track {

    private int track_id;
    private int album_id;
    private String title;
    private int runtime;

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return track_id == track.track_id &&
                album_id == track.album_id &&
                runtime == track.runtime &&
                title.equals(track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track_id, album_id, title, runtime);
    }
}
