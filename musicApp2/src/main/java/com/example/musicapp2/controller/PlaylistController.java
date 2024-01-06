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

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private UserService userService;

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable Long id){
        return new ResponseEntity<Playlist>(playlistService.getPlaylist(id), HttpStatus.OK);}

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getPlaylists(){
        return new ResponseEntity<List<Playlist>>(playlistService.getPlaylists(), HttpStatus.OK);}

    @PostMapping("/playlists")
    public ResponseEntity savePlaylist(@RequestBody CreatePlaylist createPlaylist){
        Playlist playlist = new Playlist(createPlaylist.getName());
        playlistService.savePlaylist(playlist);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/playlists/{id}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long id,@RequestParam Long song_id){
        return new ResponseEntity<Playlist>(playlistService.addSongToPlaylist(id,song_id),HttpStatus.OK);
    }

    @DeleteMapping ("/playlists/{id}")
    public ResponseEntity<Playlist> deleteSongFromPlaylist(@PathVariable Long id,@RequestParam Long song_id){
        return new ResponseEntity<Playlist>(playlistService.deleteSongFromPlaylist(id,song_id),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/playlists/update/{id}")
    public ResponseEntity updatePlaylist(@PathVariable Long id, @RequestBody CreatePlaylist createPlaylist){
        Playlist playlist= playlistService.getPlaylist(id);
        playlist.setId(id);
        playlist.setName(createPlaylist.getName());
        playlistService.updatePlaylist(playlist);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/playlists")
    public ResponseEntity<HttpStatus> deletePlaylist(@RequestParam Long id){
        if (playlistService.getPlaylist(id)!=null){
            // Delete the playlist by ID
            playlistService.deletePlaylist(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // If the song doesn't exist, return 404 Not Found
            System.out.println("id not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
