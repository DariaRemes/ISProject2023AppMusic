package com.example.musicapp_backend.controller;

import com.example.musicapp_backend.model.Song;
import com.example.musicapp_backend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/addSong")
    public Song addSong(@RequestBody Song song){return songRepository.save(song);}

    @PatchMapping("/updateSong")
    public Song updateSong(@RequestAttribute String songId, String newTitle, String newGenre){
        return songRepository.updateSongById(songId,newTitle,newGenre);
    }

    @DeleteMapping("/deleteSong")
    public Optional<Song> deleteSong(@RequestAttribute String songId){
        return songRepository.deleteSongById(songId);
    }

    @GetMapping("/getAllSongs")
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    @GetMapping("/getAllSongsByGenre")
    public  List<Song> getAllSongsByGenre(String genre){return songRepository.findAllByGenre(genre);}

    @GetMapping("/getAllSongsByTitle")
    public  List<Song> getAllSongsByTitle(String title){return songRepository.findAllByTitle(title);}

}
