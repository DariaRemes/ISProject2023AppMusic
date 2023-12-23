package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Playlist;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.PlaylistRepository;
import com.example.musicapp2.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

//    public Set<Song> getSongsFromPlaylist(Long id) {
//        Optional<Playlist> playlistOptional = playlistRepository.findById(id);
//        return playlistOptional.map(Playlist::getSongs).orElse(Collections.emptySet());
//    }

    @Override
    public Playlist getPlaylist(Long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if(playlist.isPresent()){
            return playlist.get();
        }
        throw new RuntimeException("Playlist not found with id : " + id);
    }
}
