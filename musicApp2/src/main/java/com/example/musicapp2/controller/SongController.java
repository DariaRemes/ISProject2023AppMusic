package com.example.musicapp2.controller;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/getAllSongs")
    public ResponseEntity<List<Song>> getAllSongs(){
        try{
           List<Song> songList = new ArrayList<>();
           songRepository.findAll().forEach(songList::add);

           if(songList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(songList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getSongById/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id){
        Optional<Song> songObj = songRepository.findById(id);
        if (songObj.isPresent()) {
            return new ResponseEntity<>(songObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //
    @GetMapping("/getSong/{id}")
    public String getSong(@PathVariable Long id){
        return "I have a long way to go..." + id;
    }
    //
    @PostMapping("/addSong")
    public ResponseEntity<Song> addSong(@RequestBody Song song){
        try {
            Song songObj = songRepository.save(song);
            return new ResponseEntity<>(songObj, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateSongById/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song){
        try {
            Optional<Song> songData = songRepository.findById(id);
            if(songData.isPresent()){
                Song updatedSong = songData.get();
                updatedSong.setTitle(song.getTitle());
                updatedSong.setPlayedNo(song.getPlayedNo());
                updatedSong.setGenre(song.getGenre());

                Song songObj = songRepository.save(updatedSong);
                return new ResponseEntity<>(songObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/deleteSongById/{id}")
    public ResponseEntity<HttpStatus> deleteSong(@PathVariable Long id){
        try {
            songRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //localhost:8080/songs?id=3
    @DeleteMapping("/songs")
    public String deleteSong2(@RequestParam Long id){
        return "Delete song with id = " + id;
    }

    @DeleteMapping("/deleteAllSongs")
    public ResponseEntity<HttpStatus> deleteAllSongs() {
        try {
            songRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/send_help")
    public String getSongs(){
        return "I need help with this project:(";
    }
}
