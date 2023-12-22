package com.example.musicapp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Song{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title should not be null")
    private String title;
    private int played_no = 0;
    @NotNull(message = "Genre should not be null")
    private String genre;
}
