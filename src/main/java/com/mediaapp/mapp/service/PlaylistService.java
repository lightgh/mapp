package com.mediaapp.mapp.service;

import com.mediaapp.mapp.database.PlaylistRepository;
import com.mediaapp.mapp.database.SongRepository;
import com.mediaapp.mapp.exception.PlaylistNotFoundException;
import com.mediaapp.mapp.exception.SongNotFoundException;
import com.mediaapp.mapp.model.Playlist;
import com.mediaapp.mapp.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Service
public class PlaylistService {

    // Inject the dependency of `PlaylistRepository` from application context
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

    public Iterable<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(BigInteger playlistId) {
        return getPlaylist(playlistId);
    }

    public Optional<Playlist> createPlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setCreatedOn(new Date());
        return Optional.of(playlistRepository.save(playlist));
    }

    public void deletePlaylist(BigInteger playlistId) {
        Playlist playlist = getPlaylist(playlistId);
        playlist.setId(playlistId);
        playlistRepository.delete(playlist);
    }

    public Iterable<Song> getSongs(BigInteger playlistId) {
        if (playlistId == null) {
            return songRepository.findAll();
        }
        playlistRepository.del(playlistId);
        Playlist playlist = getPlaylist(playlistId);
        return playlistRepository.getSongs(playlist.getId());
    }

    public void deleteSongs(BigInteger playlistId) {
        Playlist playlist = getPlaylist(playlistId);
        songRepository.deleteByPlaylistId(playlist.getId());
    }

    public Song addSong(BigInteger playlistId, Song song) {
        Playlist playlist = getPlaylist(playlistId);
        song.setPlaylistId(playlist.getId());
        song.setCreatedOn(new Date());
        return songRepository.save(song);
    }

    public boolean moveSong(BigInteger songId, BigInteger toPlaylistId) {
        Song song = getSong(songId);
        Playlist playlist = getPlaylist(toPlaylistId);
        return 1 == songRepository.updatePlaylist(song.getId(), playlist.getId());
    }

    public void deleteSong(BigInteger playlistId, BigInteger songId) {
        Song song = getSong(songId);
        songRepository.delete(playlistId, song.getId());
    }

    public Playlist getPlaylist(final BigInteger playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new PlaylistNotFoundException(playlistId));
    }

    private Song getSong(final BigInteger songId) {
        return songRepository.findById(songId).orElseThrow(() -> new SongNotFoundException(songId));
    }

}
