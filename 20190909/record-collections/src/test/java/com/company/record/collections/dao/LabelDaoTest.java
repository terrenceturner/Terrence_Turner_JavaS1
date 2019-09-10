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
public class LabelDaoTest {

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
    public void addGetDeleteLabel() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        Label label1 = labelDao.getLabel(label.getLabel_id());

        assertEquals(label1, label);

        labelDao.deleteLabel(label.getLabel_id());

        label1 = labelDao.getLabel(label.getLabel_id());

        assertNull(label1);

    }

    @Test
    public void getAllLabels() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        label = new Label();
        label.setName("Island");
        label.setWebsite("www.island.com");
        labelDao.addLabel(label);

        List<Label> lList = labelDao.getAllLabels();

        assertEquals(2, lList.size());

    }

    @Test
    public void updateLabel() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        label.setName("NEW NAME");
        label.setWebsite("NEW WEBSITE");
        labelDao.updateLabel(label);

        Label label1 = labelDao.getLabel(label.getLabel_id());

        assertEquals(label, label1);
    }

}