package com.example.musicapp2.controller;

import com.example.musicapp2.dto.CreatePlaylist;
import com.example.musicapp2.model.Playlist;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.service.PlaylistService;
import com.example.musicapp2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/{id}")
    public ResponseEntity getPlaylist(@PathVariable Long id){
        return new ResponseEntity(playlistService.getPlaylist(id), HttpStatus.OK);}

    @GetMapping
    public ResponseEntity getPlaylists(){
        return new ResponseEntity(playlistService.getPlaylists(), HttpStatus.OK);}

    @PostMapping
    public ResponseEntity savePlaylist(@RequestBody CreatePlaylist createPlaylist){
        Playlist playlist = new Playlist(createPlaylist.getName());
        playlistService.savePlaylist(playlist);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}/{song_id}")
    public ResponseEntity addSongToPlaylist(@PathVariable Long id,@PathVariable Long song_id){
        return new ResponseEntity(playlistService.addSongToPlaylist(id,song_id),HttpStatus.OK);
    }

    @PutMapping ("/delete/{id}/{song_id}")
    public ResponseEntity deleteSongFromPlaylist(@PathVariable Long id,@PathVariable Long song_id){
        return new ResponseEntity(playlistService.deleteSongFromPlaylist(id,song_id),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlaylist(@PathVariable Long id, @RequestBody CreatePlaylist createPlaylist){
        Playlist playlist= playlistService.getPlaylist(id);
        playlist.setId(id);
        playlist.setName(createPlaylist.getName());
        playlistService.updatePlaylist(playlist);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlaylist(@PathVariable Long id){
        Playlist playlist = playlistService.getPlaylist(id);
        playlist.getSongs().clear();
        System.out.println(playlist.getSongs());
        playlistService.updatePlaylist(playlist);
        playlistService.deletePlaylist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
