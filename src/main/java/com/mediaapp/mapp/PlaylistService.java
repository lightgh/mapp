package com.mediaapp.mapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

@Service("playlistService")
public class PlaylistService {

    // inject the dependency of `EntityManager` from application context
    @Autowired
    private EntityManager entityManager;

    // Inject the dependency of `PlaylistRepository` from application context
    @Autowired
    private PlaylistRepository playlistRepository;


    // fetch all the playlist from `playlist` table using  `PlaylistRepository`
    public Iterable<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public void getSongs(BigInteger playlistId) {
        List<Song> resultList = entityManager.createNamedQuery("songsByPlaylistId", Song.class)
                .setParameter(1, playlistId)
                .getResultList();
        System.out.println(resultList);
    }

    public Playlist getPlaylist(final BigInteger playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new PlaylistNotFoundException(playlistId));
    }


}
