package com.example.musicapp2.controller;

import com.example.musicapp2.dto.CreatePlaylist;
import com.example.musicapp2.model.Playlist;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.model.User;
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

    @Autowired
    private UserService userService;

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
        Playlist playlist= new Playlist(createPlaylist.getName());
        playlist.setId(id);
        playlistService.updatePlaylist(playlist);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{playlistId}")
    public ResponseEntity deletePlaylistUser(@PathVariable Long userId,@PathVariable Long playlistId){
        Playlist playlist = playlistService.getPlaylist(playlistId);
        playlist.getSongs().clear();
        playlistService.updatePlaylist(playlist);
        User user = userService.getUser(userId);
        user.getPlaylists().remove(playlist);
        userService.updateUser(user);
        playlistService.deletePlaylist(playlistId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
