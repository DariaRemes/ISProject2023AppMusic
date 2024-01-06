package com.example.musicapp2.dto;

import com.example.musicapp2.model.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlaylist {
    private String name;
}
