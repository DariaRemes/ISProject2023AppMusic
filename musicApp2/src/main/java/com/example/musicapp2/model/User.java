package com.example.musicapp2.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("user")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends AbstractUser{
//    private Set<Playlist> playlists = new HashSet<>();
}
