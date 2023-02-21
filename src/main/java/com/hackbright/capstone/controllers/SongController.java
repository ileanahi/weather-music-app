package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.SongDto;
import com.hackbright.capstone.repositories.SongRepository;
import com.hackbright.capstone.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/favorite-song/{userId}")
    public void addSong(@PathVariable Long userId, @RequestBody SongDto songDto){
        songService.addSong(userId, songDto);
    }

    @GetMapping("/favorite-song")
    public List<SongDto> getAllSongs() {
        return songService.getAllSongs();
    }

    @DeleteMapping("/deleteSong")
    public void deleteSongById(@PathVariable Long songId) {
        songService.deleteSongById(songId);
    }
}
