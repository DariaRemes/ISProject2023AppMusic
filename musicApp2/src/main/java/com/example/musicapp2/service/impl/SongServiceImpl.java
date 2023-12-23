package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.SongRepository;
import com.example.musicapp2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Override
    public List<Song> getSongs() {
        Sort sort = Sort.by(Sort.Direction.ASC,"title");
        return songRepository.findAll(sort);
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

    @Override
    public List<Song> getSongsByTitle(String title) {
        return songRepository.findSongByTitle(title);
    }

    @Override
    public List<Song> getSongsByGenre(String genre) {
        return songRepository.findSongByGenre(genre);
    }

    @Override
    public List<Song> getSongsByKeyword(String keyword) {
        return songRepository.findSongByTitleContaining(keyword);
    }


}
