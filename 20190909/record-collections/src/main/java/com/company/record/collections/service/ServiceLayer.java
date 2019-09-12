package com.company.record.collections.service;

import com.company.record.collections.dao.AlbumDao;
import com.company.record.collections.dao.ArtistDao;
import com.company.record.collections.dao.LabelDao;
import com.company.record.collections.dao.TrackDao;
import com.company.record.collections.model.Album;
import com.company.record.collections.model.Artist;
import com.company.record.collections.model.Label;
import com.company.record.collections.model.Track;
import com.company.record.collections.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel){
        // Persist Album
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setRelease_date(viewModel.getReleaseDate());
        a.setPrice(viewModel.getListPrice());
        a.setLabel_id(viewModel.getLabel().getLabel_id());
        a.setArtist_id(viewModel.getArtist().getArtist_id());
        a = albumDao.addAlbum(a);
        viewModel.setId(a.getAlbum_id());

        // Add Album Id to Tracks and Persist Tracks
        List<Track> tracks = viewModel.getTracks();

        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbum_id(viewModel.getId());
                    trackDao.addTrack(t);
                });

        tracks = trackDao.getTracksByAlbum(viewModel.getId());
        viewModel.setTracks(tracks);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id){

        //Get the Album object first

        Album album = albumDao.getAlbum(id);
        return buildAlbumViewModel(album);

    }

    private AlbumViewModel buildAlbumViewModel(Album album) {
        //Get the Associated Artist

        Artist artist = artistDao.getArtist(album.getArtist_id());

        //Get the associated label
        Label label = labelDao.getLabel(album.getLabel_id());

        //Assemble the tracks associated with the album
        List<Track> trackList = trackDao.getTracksByAlbum(album.getAlbum_id());

        //Assemble the AlbumViewModel
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getAlbum_id());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getRelease_date());
        avm.setListPrice(album.getPrice());
        avm.setArtist(artist);
        avm.setLabel(label);
        avm.setTracks(trackList);

        //return AlbumViewModel
        return avm;

    }

    public List<AlbumViewModel> findAllAlbums() {

        List<Album> albumList = albumDao.getAllAlbums();

        List<AlbumViewModel> avmList = new ArrayList<>();

        //GOes through albumList and build an AlbumViewModel for each album
        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel){
        //Update the album information

        Album album = new Album();
        album.setAlbum_id(viewModel.getId());
        album.setArtist_id(viewModel.getArtist().getArtist_id());
        album.setLabel_id(viewModel.getLabel().getLabel_id());
        album.setTitle(viewModel.getTitle());
        album.setPrice(viewModel.getListPrice());
        album.setRelease_date(viewModel.getReleaseDate());

        albumDao.updateAlbum(album);

        // We don't know if any track have been removed so delete all associated tracks
        // and then associate the tracks in the viewModel with the album
        List<Track> trackList = trackDao.getTracksByAlbum(album.getAlbum_id());
        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getTrack_id()));

        List<Track> tracks = viewModel.getTracks();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbum_id(viewModel.getId());
                    trackDao.addTrack(t);
                });
    }

    @Transactional
    public void removeAlbum(int id){
        //Remove all associated tracks first
        List<Track> trackList = trackDao.getTracksByAlbum(id);

        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getTrack_id()));

        //Remove album
        albumDao.deleteAlbum(id);
    }

    //
    // Artist API
    //

    public Artist saveArtist(Artist artist) {

        return artistDao.addArtist(artist);
    }

    public Artist findArtist(int id) {

        return artistDao.getArtist(id);
    }

    public List<Artist> findAllArtists() {

        return artistDao.getAllArtist();
    }

    public void updateArtist(Artist artist) {

        artistDao.updateArtist(artist);
    }

    public void removeArtist(int id) {

        artistDao.deleteArtist(id);
    }

    //
    // Label API
    //

    public Label saveLabel(Label label) {

        return labelDao.addLabel(label);
    }

    public Label findLabel(int id) {

        return labelDao.getLabel(id);
    }

    public List<Label> findAllLabels() {

        return labelDao.getAllLabels();
    }

    public void updateLabel(Label label) {

        labelDao.updateLabel(label);
    }

    public void removeLabel(int id) {

        labelDao.deleteLabel(id);
    }

}
