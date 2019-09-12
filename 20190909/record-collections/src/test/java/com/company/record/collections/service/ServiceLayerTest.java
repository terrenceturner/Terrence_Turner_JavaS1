package com.company.record.collections.service;

import com.company.record.collections.dao.*;
import com.company.record.collections.model.Album;
import com.company.record.collections.model.Artist;
import com.company.record.collections.model.Label;
import com.company.record.collections.model.Track;
import com.company.record.collections.viewmodel.AlbumViewModel;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.swing.text.LabelView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;
    private ServiceLayer service;

    private void setupAlbumDaoMock(){

        albumDao = mock(AlbumJdbcTemplateImpl.class);
        Album album = new Album();
        album.setAlbum_id(1);
        album.setArtist_id(45);
        album.setLabel_id(10);
        album.setTitle("Greatest Hits");
        album.setPrice(new BigDecimal("14.99"));
        album.setRelease_date(LocalDate.of(1999,05,15));

        Album album2 = new Album();
        album2.setArtist_id(45);
        album2.setLabel_id(10);
        album2.setTitle("Greatest Hits");
        album2.setPrice(new BigDecimal("14.99"));
        album2.setRelease_date(LocalDate.of(1999,05,15));

        List<Album> albumList = new ArrayList<>();
        albumList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(albumList).when(albumDao).getAllAlbums();
    }

    private void setupLabelDaoMock(){
        labelDao = mock(LabelJdbcTemplateImpl.class);
        Label label = new Label();
        label.setLabel_id(10);
        label.setName("Blue Note");
        label.setWebsite("wwww.bluenote.com");

        Label label2 = new Label();
        label2.setName("Blue Note");
        label2.setWebsite("www.bluenote.com");

        List<Label> labelList = new ArrayList<>();
        labelList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(labelList).when(labelDao).getAllLabels();


    }

    private void setupTrackDaoMock(){

        trackDao = mock(TrackJdbcTemplateImpl.class);
        Track track = new Track();
        track.setTrack_id(1);
        track.setAlbum_id(1);
        track.setTitle("Number 1 Hit!");
        track.setRuntime(180);

        Track track2 = new Track();
        track2.setAlbum_id(1);
        track2.setTitle("Number 1 Hit!");
        track2.setRuntime(180);

        List<Track> trackList = new ArrayList<>();
        trackList.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(trackList).when(trackDao).getAllTracks();
        doReturn(trackList).when(trackDao).getTracksByAlbum(1);
    }

    private void setupArtistDaoMock(){

        artistDao = mock(ArtistJdbcTemplateImpl.class);
        Artist artist = new Artist();
        artist.setArtist_id(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List<Artist> artistList = new ArrayList();
        artistList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(artistList).when(artistDao).getAllArtist();
    }



    @Before
    public void setUp() throws Exception{
        setupAlbumDaoMock();
        setupArtistDaoMock();
        setupLabelDaoMock();
        setupTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);


    }

    @Test
    public void saveFindAlbum(){

        AlbumViewModel avm = new AlbumViewModel();
        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999,05,15));
        avm.setTitle("Greastest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@Rockstar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRuntime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> trackList = new ArrayList<>();
        trackList.add(track);

        avm.setTracks(trackList);
        avm = service.saveAlbum(avm);
        AlbumViewModel fromService = service.findAlbum(avm.getId());
        assertEquals(avm, fromService);
    }

    @Test
    public void saveFindFindAllArtist(){
        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);
        Artist fromService = service.findArtist(artist.getArtist_id());
        assertEquals(artist, fromService);

        List<Artist> artistList = service.findAllArtists();
        assertEquals(1, artistList.size());
        assertEquals(artist, artistList.get(0));
    }

    @Test
    public void saveFindFindAllLabels(){
        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        label = service.saveLabel(label);
        Label fromService = service.findLabel(label.getLabel_id());
        assertEquals(label, fromService);

        List<Label> labelList = service.findAllLabels();
        assertEquals(1, labelList.size());
        assertEquals(label, labelList.get(0));
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void saveAlbum() {

        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRuntime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        avm.setTracks(tList);

        avm = service.saveAlbum(avm);

        AlbumViewModel fromService = service.findAlbum(avm.getId());

        assertEquals(avm, fromService);
    }

    @Test
    public void findAlbum() {

        AlbumViewModel avm = new AlbumViewModel();
        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999,05,15));
        avm.setTitle("Greastest Hits");


        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        service.findAlbum(avm.getId());


    }

    @Test
    public void findAllAlbums() {
    }

    @Test
    public void updateAlbum() {

        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("15.99"));
        avm.setReleaseDate(LocalDate.of(1999, 04, 17));
        avm.setTitle("Greatest Hits vol 2");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        service.updateAlbum(avm);

        AlbumViewModel fromService = service.findAlbum(avm.getId());
        assertEquals(avm, fromService);




    }

    @Test
    public void testUpdateAlbum() {

        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(1);
        avm.setListPrice(new BigDecimal("15.99"));
        avm.setReleaseDate(LocalDate.of(1999, 04, 17));
        avm.setTitle("Greatest Hits vol 2");

        Artist artist = new Artist();
        artist.setArtist_id(45);

        avm.setArtist(artist);

        Label label = new Label();
        label.setLabel_id(10);

        avm.setLabel(label);


        ArgumentCaptor<Album> albumCaptor = ArgumentCaptor.forClass(Album.class);
        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());
        service.updateAlbum(avm);

        verify(albumDao,times(1)).updateAlbum(albumCaptor.getValue());

        Album album = albumCaptor.getValue();

        assertEquals(1,album.getAlbum_id());
        assertEquals(avm.getListPrice(),album.getPrice());
        assertEquals(avm.getReleaseDate(),album.getRelease_date());
        assertEquals(avm.getTitle(),album.getTitle());

    }

    @Test
    public void deleteLabel(){

//        Label label = new Label();
//        label.setLabel_id(10);
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());
        service.removeLabel(10);
        verify(labelDao, times(1)).deleteLabel(integerCaptor.getValue());

        assertEquals(10,integerCaptor.getValue().intValue());

    }
}