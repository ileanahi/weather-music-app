package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.SongDto;
import com.hackbright.capstone.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/newSong")
    public List<String> addSong(@RequestBody SongDto songDto) {
        return songService.addSong(songDto);
    }

    @DeleteMapping("/deleteSong")
    public void deleteSongById(@PathVariable Long songId) {
        songService.deleteSongById(songId);
    }
}
