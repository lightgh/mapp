package com.mediaapp.mapp;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/media-playlist-mod")
@RestController
public class MediaPlaylistModRestController {

    @GetMapping("/{name}")
    public Playlist getPlaylist(@PathVariable String name){
        Playlist playlist = new Playlist();
        playlist.setName(name);
        return playlist;
    }

    @PutMapping("/playlist/{id}")
    public Playlist getPlaylist(@PathVariable long id, Playlist playlist){
        return playlist;
    }



}
