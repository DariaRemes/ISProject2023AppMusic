package com.example.musicapp_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
public class Song {
    @Id
    private String id;

    private String title;
    private int playedNo;
    private String genre;

    public Song(String title, int playedNo, String genre) {
        this.title = title;
        this.playedNo = playedNo;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayedNo() {
        return playedNo;
    }

    public void setPlayedNo(int playedNo) {
        this.playedNo = playedNo;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                ", title='" + title + '\'' +
                ", playedNo=" + playedNo +
                ", genre='" + genre + '\'' +
                '}';
    }
}
