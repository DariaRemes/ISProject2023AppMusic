package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Admin;
import com.example.musicapp2.model.Artist;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.ArtistRepository;
import com.example.musicapp2.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistRepository artistRepository;


    @Override
    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getArtist(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if(artist.isPresent())
            return artistRepository.findById(id).get();
        else
            throw new RuntimeException("Artist not found with id : " + id);
    }

    @Override
    public Artist getByUserName(String username) {
        return artistRepository.findByUsername(username);
    }

    @Override
    public Artist findByUsername(String username) {
        return artistRepository.findByUsername(username);
    }

    @Override
    public Artist findByUsernameAndPassword(String username, String password) {
        return artistRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long id) {
      artistRepository.deleteById(id);
    }
}
