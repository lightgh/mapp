package com.mediaapp.mapp.controller;

import com.mediaapp.mapp.exception.PlaylistNotFoundException;
import com.mediaapp.mapp.model.Playlist;
import com.mediaapp.mapp.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.Arrays;


//@RequestMapping("/playlist")
@Controller
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public String listPlaylistAndSongs(Model model) {
        model.addAttribute("playlists", playlistService.getAllPlaylists());
        return "index";
    }

   /*

   @RequestMapping("/{id}")
    public String getAllPlaylists(@PathVariable long id) {
        return "GetAllPlaylists (Id): " + id;
    }

    @RequestMapping("/namedVariable/{uId}")
    public String getAllSavedPlaylists(@PathVariable("uId") long uniqueId){
        return "Get All Saved Playlists (UniqueId): " + uniqueId;
    }

    @RequestMapping(value = {"/album"})
    public Object[] getOneSavedPlaylist() {
        String[] albumSubList = {"Rock-Album", "Blues-Album"};
        return Arrays.asList("Rocking-Album", "Blueing-Album", albumSubList).toArray();
//        return albumSubList;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"reqCall"})
    public String getRequestCall(){
        return "From RequestCall Method";
    }

    @RequestMapping(value = {"argPassing"})
    public Object[] getParamsCalled(@RequestParam("name") String name, @RequestParam("address") String address) {
        return Arrays.asList(name, address).toArray();
    }

    @RequestMapping(value = {"argPassing2"}, params = {"name", "address"})
    public Object[] getParamsCalled2(@RequestParam("name") String name, @RequestParam("address") String address) {
        return Arrays.asList(name, address).toArray();
    }

    @RequestMapping(value = "/reqHeader", headers = {"content-type=application/json", "Accept=application/json" })
    public String[] getHeadersCalled(){
        return new String[] {"Heading1", "Heading2"};
    }

    @RequestMapping(value = "consumeReq", consumes = {"text/plain", "application/*" } )
    public String[] getRequestMappingConsumes(){
        return new String[]{"Consuming Text/Plain", "Consuming/Applicatin./*" };
    }

    @RequestMapping(value = "produceReq", produces = {"text/plain", "application/*"})
    public String[] producesReqApp() {
        return new String[]{"Plain", "text", "Producing RequestMapping Handler"};
    }


    @RequestMapping("/aplaylist/{id}")
    public Playlist getPlaylist(@PathVariable BigInteger id){
        try {
            return playlistService.getPlaylist(id);
        } catch (PlaylistNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

*/
}
