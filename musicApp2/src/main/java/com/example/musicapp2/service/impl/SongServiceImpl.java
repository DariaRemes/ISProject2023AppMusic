package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.SongRepository;
import com.example.musicapp2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }
    @Override
    public Song getSong(Long id) {
        Optional<Song> song = songRepository.findById(id);
        if(song.isPresent()){
            return song.get();
        }
        throw new RuntimeException("Song not found with id : " + id);
    }
    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);

    }


}
