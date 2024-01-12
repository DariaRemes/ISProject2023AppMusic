package com.example.musicapp2.controller;

import com.example.musicapp2.dto.*;
import com.example.musicapp2.model.*;
import com.example.musicapp2.repository.ArtistRepository;
import com.example.musicapp2.service.ArtistService;

import com.example.musicapp2.service.PlaylistService;
import com.example.musicapp2.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity getArtists(){
        return new ResponseEntity(artistService.getArtists(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getArtist(@PathVariable Long id){
        return new ResponseEntity(artistService.getArtist(id), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Artist> findByUsername(@RequestBody FindByUsername findByUsername){
        return new ResponseEntity<>(artistService.getByUserName(findByUsername.getUsername()),HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity findByUsernameAndPassword(@RequestBody FindByUserNameAndPassword findBy){
        Artist artist = artistService.findByUsernameAndPassword(findBy.getUsername(), findBy.getPassword());
        if(artist != null){
            return new ResponseEntity(artist,HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/checkArtist")
    public ResponseEntity checkArtist(@RequestBody CheckUserInDatabase checkArtistInDatabase) {
        Artist artist = artistService.checkArtist(checkArtistInDatabase.getUsername(), checkArtistInDatabase.getEmail(), checkArtistInDatabase.getPassword());
        if (artist != null) {
            return new ResponseEntity(artist, HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addArtist")
    public ResponseEntity addArtist(@RequestBody CreateAccount createAccount){
        Artist artist =  new Artist(createAccount.getUsername(), createAccount.getEmail(), createAccount.getPassword());
        artistService.saveArtist(artist);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/playlists")
    public ResponseEntity savePlaylist(@RequestParam Long id, @RequestBody CreatePlaylist createPlaylist){
        Artist artist = artistService.getArtist(id);
        Playlist playlist = new Playlist(createPlaylist.getName());
        playlistService.savePlaylist(playlist);
        artist.setId(id);
        artist.getPlaylists().add(playlist);
        artistService.saveArtist(artist);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArtist(@PathVariable Long id, @RequestBody CreateAccount createAccount) {
       Artist artist = new Artist(createAccount.getUsername(), createAccount.getEmail(), createAccount.getPassword()) ;
       artist.setId(id);
       artistService.updateArtist(artist);
       return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtist(@PathVariable Long id){
        artistService.deleteArtist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
