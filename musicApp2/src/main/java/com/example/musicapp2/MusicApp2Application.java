package com.example.musicapp2;

import com.example.musicapp2.model.Song;
import com.example.musicapp2.repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicApp2Application {

//    private static final Logger log =
//            LoggerFactory.getLogger(MusicApp2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(MusicApp2Application.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(SongRepository songRepository){
//        return (args) -> {
//            //save a few songs
//            songRepository.save(new Song("Guilty",0, "Kpop"));
//            songRepository.save(new Song("Blue",0, "Kpop"));
//            songRepository.save(new Song("Borderline",0, "Indie"));
//            songRepository.save(new Song("Nothing else matters",0, "Rock"));
//
//            //fetch all songs
//            log.info("Songs found with findAll():");
//            log.info("---------------------------");
//            songRepository.findAll().forEach(song -> {
//                log.info(song.toString());
//            });
//            log.info("");
//
//            //fetch song by id
////            Song song = songRepository.findById(1L);
////            log.info("Song found with findById(1L):");
////            log.info("--------------------------------");
////            log.info(song.toString());
////            log.info("");
//        };
//    }

}
