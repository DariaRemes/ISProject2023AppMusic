package com.example.musicapp2.controller;

import com.example.musicapp2.model.Artist;
import com.example.musicapp2.model.User;
import com.example.musicapp2.service.ArtistService;
import com.example.musicapp2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtist(@PathVariable Long id){
        return new ResponseEntity<Artist>((Artist) artistService.getAbstractUser(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Artist> saveArtist(@Valid @RequestBody Artist artist){
        return new ResponseEntity<Artist>((Artist) artistService.saveAbstractUser(artist),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist){
        artist.setId(id);
        return new ResponseEntity<Artist>((Artist) artistService.updateAbstractUser(artist),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable Long id){
        artistService.deleteAbstractUser(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
