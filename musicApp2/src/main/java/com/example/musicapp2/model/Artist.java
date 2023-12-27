package com.example.musicapp2.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@DiscriminatorValue("artist")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Artist extends User{
//    private Set<Song> songs = new HashSet<>();
}
