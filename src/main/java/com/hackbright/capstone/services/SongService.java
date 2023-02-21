package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.SongDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface SongService {
    @Transactional
    List<String> addSong(Long userId, SongDto songDto);

    @Transactional
    void deleteSongById(Long songId);

    List<SongDto> getAllSongs();
}
