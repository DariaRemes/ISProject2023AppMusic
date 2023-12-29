package com.example.musicapp2.controller;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.service.SongService;
import com.example.musicapp2.service.impl.SongServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id){
       return new ResponseEntity<Song>(songService.getSong(id),HttpStatus.OK);
    }
    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getSongs(){
        return new ResponseEntity<List<Song>>(songService.getSongs(), HttpStatus.OK);}

    @PostMapping("/songs")
    public ResponseEntity<Song> saveSong(@Valid @RequestBody Song song){
        return new ResponseEntity<Song>(songService.saveSong(song),HttpStatus.CREATED);
    }
    @PutMapping("/songs/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song){
        song.setId(id);
        return new ResponseEntity<Song>(songService.updateSong(song),HttpStatus.OK);
    }
    //localhost:8080/songs?id=3
    @DeleteMapping("/songs")
    public ResponseEntity<HttpStatus> deleteSong(@RequestParam Long id){
        if (songService.getSong(id)!=null){
                // Delete the song by ID
                songService.deleteSong(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
                // If the song doesn't exist, return 404 Not Found
            System.out.println("id not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/songs/filterByTitle")
    public ResponseEntity<List<Song>> getSongsByTitle(@RequestParam String title){
        return new ResponseEntity<List<Song>>(songService.getSongsByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/songs/filterByGenre")
    public ResponseEntity<List<Song>> getSongsByGenre(@RequestParam String genre){
        return new ResponseEntity<List<Song>>(songService.getSongsByGenre(genre),HttpStatus.OK);
    }
    @GetMapping("/songs/filterByKeyword")
    public ResponseEntity<List<Song>> getSongsByKeyword(@RequestParam String keyword){
        return new ResponseEntity<List<Song>>(songService.getSongsByKeyword(keyword),HttpStatus.OK);
    }

}
