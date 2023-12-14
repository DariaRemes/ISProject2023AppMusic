package com.example.musicapp_backend;

import com.example.musicapp_backend.model.Song;
import com.example.musicapp_backend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
//@Component
public class MongoDBConnection implements CommandLineRunner{

    @Autowired
    private SongRepository songRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDBConnection.class, args);
        //System.out.println("Hello~");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Songs found with findAll():");
        System.out.println("-------------------------------");
//        for (Song song : songRepository.findAll()) {
//            System.out.println(song);
//        }
//        System.out.println(songRepository.findAll());
        //System.out.println("Songs found with findAllByGenre():");
       // System.out.println("-------------------------------");
        System.out.println(songRepository.findAllByGenre("Alternative"));
       // System.out.println(songRepository.findAllByTitle("Umbrella"));
//        songRepository.updateSong("6577005d91088664503d887b","LetItHappen","Indie");
        //songRepository.deleteSongById("6577005d91088664503d887b");
        //songRepository.save(new Song("Let it happen", 0,"Alternative"));
        System.out.println();
    }
}
