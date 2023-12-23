package com.example.musicapp2.service;

import com.example.musicapp2.model.Playlist;
import com.example.musicapp2.model.Song;

import java.util.Set;

public interface PlaylistService {
//    public Set<Song> getSongsFromPlaylist(Long id);

    public Playlist getPlaylist(Long id);
}
