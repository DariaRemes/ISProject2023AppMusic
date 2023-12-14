package com.example.musicapp_backend.repository;

import com.example.musicapp_backend.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SongRepository extends MongoRepository <Song,String> {


    @Query("{ 'genre' : ?0 }")
    List<Song> findAllByGenre(String genre);

    @Query("{ 'title' : ?0 }")
    List<Song> findAllByTitle(String title);


    @Query("{'_id': ?0 }")
    void updateSongById(String songId, String newTitle, String genre);

    @Query("{'_id': ?0}")
    void deleteSongById(String songId);

    //public long count();
}
