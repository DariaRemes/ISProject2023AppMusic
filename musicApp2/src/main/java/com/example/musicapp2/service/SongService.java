package com.example.musicapp2.service;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Song save(Song song){
        return songRepository.save(song);
    }

    public Optional<Song> finfById(Long id){
        return songRepository.findById(id);
    }

    public void deleteById(Long id){
        songRepository.deleteById(id);
    }
}
