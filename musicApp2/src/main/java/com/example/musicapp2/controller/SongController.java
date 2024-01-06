package com.example.musicapp2.controller;

import com.example.musicapp2.dto.AdaugareCantec;
import com.example.musicapp2.dto.UpdateSong;
import com.example.musicapp2.model.Artist;
import com.example.musicapp2.model.Playlist;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.service.ArtistService;
import com.example.musicapp2.service.PlaylistService;
import com.example.musicapp2.service.SongService;
import com.example.musicapp2.service.impl.SongServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id){
       return new ResponseEntity<Song>(songService.getSong(id),HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Song>> getSongs(){
        return new ResponseEntity<List<Song>>(songService.getSongs(), HttpStatus.OK);}

//    @PostMapping("")
//    public ResponseEntity<Song> saveSong(@Valid @RequestBody Song song){
//        return new ResponseEntity<Song>(songService.saveSong(song),HttpStatus.CREATED);
//    }
    @PostMapping("")
    public ResponseEntity addSong(@RequestBody AdaugareCantec adaugareCantec){
        Song song = new Song(adaugareCantec.getTitle(),adaugareCantec.getGenre(),adaugareCantec.getArtist());
        songService.saveSong(song);
        Artist a = artistService.getByUserName(adaugareCantec.getArtist());
        if(a!=null) {
            a.getSongs().add(song);
            artistService.updateArtist(a);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateSong(@PathVariable Long id, @RequestBody UpdateSong updateSong){
        Song song = new Song(updateSong.getTitle(),updateSong.getPlayed_no(), updateSong.getGenre(), updateSong.getArtist());
        song.setId(id);
        songService.updateSong(song);
        return new ResponseEntity(HttpStatus.OK);
}
    //localhost:8080/songs?id=3
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSong(@PathVariable Long id){
          Song song = songService.getSong(id);
          Artist artist = artistService.getByUserName(song.getArtist());
          if(artist!=null){
              artist.getSongs().remove(song);
              artistService.updateArtist(artist);
          }
          for (Playlist playlist : playlistService.getPlaylists()){
              if(playlist.getSongs().contains(song)){
                  playlistService.deleteSongFromPlaylist(playlist.getId(), song.getId());
              }
          }
          songService.deleteSong(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filterByTitle")
    public ResponseEntity<List<Song>> getSongsByTitle(@RequestParam String title){
        return new ResponseEntity<List<Song>>(songService.getSongsByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/filterByGenre")
    public ResponseEntity<List<Song>> getSongsByGenre(@RequestParam String genre){
        return new ResponseEntity<List<Song>>(songService.getSongsByGenre(genre),HttpStatus.OK);
    }
    @GetMapping("/filterByKeyword")
    public ResponseEntity<List<Song>> getSongsByKeyword(@RequestParam String keyword){
        return new ResponseEntity<List<Song>>(songService.getSongsByKeyword(keyword),HttpStatus.OK);
    }

    @GetMapping("/filterByArtist")
    public ResponseEntity<List<Song>> getSongsByArtist(@RequestParam String artist){
        return new ResponseEntity<List<Song>>(songService.getSongsByArtist(artist),HttpStatus.OK);
    }

}
