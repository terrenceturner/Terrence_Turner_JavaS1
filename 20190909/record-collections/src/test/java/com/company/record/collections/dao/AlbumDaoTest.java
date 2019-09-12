package com.company.record.collections.dao;

import com.company.record.collections.model.Album;
import com.company.record.collections.model.Artist;
import com.company.record.collections.model.Label;
import com.company.record.collections.model.Track;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AlbumDaoTest {

    @Autowired
    protected AlbumDao dao;

    @Autowired
    protected LabelDao labelDao;

    @Autowired
    protected ArtistDao artistDao;

    @Autowired
    protected TrackDao trackDao;


    @Before
    public void setUp() throws Exception {
        List<Track> tList = trackDao.getAllTracks();
        for (Track t : tList) {
            trackDao.deleteTrack(t.getTrack_id());
        }

        List<Album> aList = dao.getAllAlbums();

        for (Album a : aList) {
            dao.deleteAlbum(a.getAlbum_id());
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
    public void getAddDeleteAlbum() {

        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2010, 1, 5));
        album.setPrice(new BigDecimal( "21.95"));

        album = dao.addAlbum(album);

        Album album1 = dao.getAlbum(album.getAlbum_id());

        assertEquals(album, album1);

        dao.deleteAlbum(album.getAlbum_id());

        album1 = dao.getAlbum(album.getAlbum_id());

        assertNull(album1);

    }

    @Test
    public void getAllAlbum() {

        Artist artist = new Artist();
        artist.setArtist_id(1111);
        artist.setName("Queen");
        artist.setInstagram("@Queen");
        artist.setTwitter("@Queen");

        Label label = new Label();
        label.setLabel_id(1112);
        label.setName("Queen Records");
        label.setWebsite("queen.com");

        Album album = new Album();
        album.setTitle("Queen Greastest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setRelease_date(LocalDate.of(1992, 2, 17));
        album.setLabel_id(label.getLabel_id());
        album.setPrice(new BigDecimal("9.1"));

        dao.addAlbum(album);

        artist = new Artist();
        artist.setArtist_id(1111);
        artist.setName("Drake");
        artist.setInstagram("@Drake");
        artist.setTwitter("@Drake");

        label = new Label();
        label.setLabel_id(1112);
        label.setName("Drake Records");
        label.setWebsite("drake.com");

        album = new Album();
        album.setTitle("Drake Greastest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setRelease_date(LocalDate.of(2019, 8, 17));
        album.setLabel_id(label.getLabel_id());
        album.setPrice(new BigDecimal("10.1"));

        dao.addAlbum(album);

        List<Album> albumList = dao.getAllAlbums();

        assertEquals(2, albumList.size());

    }

    @Test
    public void updateAlbum() {

        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2010, 1, 1));
        album.setPrice(new BigDecimal(" 16.95"));

        album = dao.addAlbum(album);

        album.setTitle("NEW TITLE");
        album.setRelease_date(LocalDate.of(2000, 7, 7));
        album.setPrice(new BigDecimal( "15.68"));

        dao.updateAlbum(album);

        Album album1 = dao.getAlbum(album.getAlbum_id());
        assertEquals(album, album1);


    }

}