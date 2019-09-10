package com.company.record.collections.dao;

import com.company.record.collections.model.Album;
import com.company.record.collections.model.Artist;
import com.company.record.collections.model.Label;
import com.company.record.collections.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArtistDaoTest {

    @Autowired
    TrackDao trackDao;
    @Autowired
    AlbumDao albumDao;
    @Autowired
    ArtistDao artistDao;
    @Autowired
    LabelDao labelDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Track> tList = trackDao.getAllTracks();
        for (Track t : tList) {
            trackDao.deleteTrack(t.getTrack_id());
        }

        List<Album> aList = albumDao.getAllAlbums();

        for (Album a : aList) {
            albumDao.deleteAlbum(a.getAlbum_id());
        }

        List<Artist> artistList = artistDao.getAllArtist();

        for (Artist a : artistList) {
            artistDao.deleteArtist(a.getArtist_id());
        }

        List<Label> lList = labelDao.getAllLabels();

        for (Label l : lList) {
            labelDao.deleteLabel(l.getLabel_id());
        }

    }

    @Test
    public void addGetDeleteArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getArtist_id());

        assertEquals(artist, artist1);

        artistDao.deleteArtist(artist.getArtist_id());

        artist1 = artistDao.getArtist(artist.getArtist_id());

        assertNull(artist1);
    }

    @Test
    public void updateArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist.setName("Pop Star");
        artist.setInstagram("@PopStar");
        artist.setTwitter("@ThePopstar");

        artistDao.updateArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getArtist_id());

        assertEquals(artist, artist1);
    }

    @Test
    public void getAllArtists() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist = new Artist();
        artist.setName("Super Star");
        artist.setInstagram("@SuperStart");
        artist.setTwitter(("@TheSuperStar"));

        artist = artistDao.addArtist(artist);

        List<Artist> aList = artistDao.getAllArtist();
        assertEquals(2, aList.size());

    }

}