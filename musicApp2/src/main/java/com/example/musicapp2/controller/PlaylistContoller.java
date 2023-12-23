package com.example.musicapp2.controller;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public class PlaylistContoller {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Set<Song>> getSongs(@PathVariable Long id){
        return new ResponseEntity<Set<Song>>(playlistService.getSongsFromPlaylist(id), HttpStatus.OK);}

}
