package com.mediaapp.mapp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RequestMapping("/media-playlist")
@Controller
public class MediaPlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public String fetchAllPlaylist(Model model) {
        model.addAttribute("playlists", Arrays.asList(new Playlist()));
        // template `playlists` will be rendered using data from `Model`
        return "index";
    }

    @PostMapping("/usingModelAndView")
    public ModelAndView createPlaylist(@RequestBody Playlist playlist){
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("playlists", playlist);
        // template `playlists` will be rendered using data from attributes
        return new ModelAndView("index", attributes);
    }

    @GetMapping("/usingResponseBody")
    public @ResponseBody Playlist fetchAllPlaylist(){
        return new Playlist();
    }

    @GetMapping("/usingRequestParamAndResponseBody")
    public @ResponseBody Playlist fetchAllPlaylist(@RequestParam String name){
        Playlist playlist = new Playlist();
        playlist.setName(name);
        return playlist;
    }

}

