package com.example.musicapp2.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;


@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Song{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int playedNo;
    private String genre;


}
