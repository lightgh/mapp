package com.mediaapp.mapp.controller.data;

import com.mediaapp.mapp.model.Playlist;
import com.mediaapp.mapp.model.Song;
import com.mediaapp.mapp.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RequestMapping("/playlist")
@RestController
public class PlaylistRestController {


    PlaylistService playlistService;

    @Qualifier("playlistService")
    @Autowired
    public void setService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/")
    public String root() {
        return "application is running!";
    }

    @GetMapping("/all")
    public Iterable<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(final @PathVariable("id") BigInteger playlistId) {
        return playlistService.getPlaylistById(playlistId);
    }

    @PostMapping("/name")
    public Optional<Playlist> createPlaylist(final @PathVariable String name) {
        return playlistService.createPlaylist(name);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(final @PathVariable("id") BigInteger playlistId) {
        playlistService.deletePlaylist(playlistId);
    }

    @GetMapping("/{id}/songs")
    public Iterable<Song> getSongsInPlaylist(@PathVariable("id") BigInteger playlistId) {
        return playlistService.getSongs(playlistId);
    }

    @DeleteMapping("/{id}/songs")
    public void deleteAllSongsInPlaylist(final @PathVariable("id") BigInteger playlistId) {
        playlistService.deleteSongs(playlistId);
    }

    @PostMapping("/{id}/add")
    public Song addSongToPlaylist(final @PathVariable("id") BigInteger playlistId,
                                  final @RequestBody Song song) {
        return playlistService.addSong(playlistId, song);
    }

    @GetMapping("/songs")
    public Iterable<Song> getAllSongs() {
        return playlistService.getSongs(null);
    }

    @PutMapping("/songs/{id}/move")
    public boolean moveSongToDifferentPlaylist(@PathVariable("id") BigInteger songId,
                                               @RequestParam("to_playlist") BigInteger toPlaylistId) {
        return playlistService.moveSong(songId, toPlaylistId);
    }

    @DeleteMapping("/{id}/songs/{song_id}")
    public void deleteFromPlaylist(final @PathVariable("id") BigInteger playlistId,
                                   final @PathVariable("song_id") BigInteger songId) {
        playlistService.deleteSong(playlistId, songId);
    }

}
