package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.SongDto;
import com.hackbright.capstone.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/user/{userId}")
    public void addSong(@RequestBody SongDto songDto,@PathVariable Long userId){
        songService.addSong(songDto, userId);
    }

    @DeleteMapping("/deleteSong")
    public void deleteSongById(@PathVariable Long songId) {
        songService.deleteSongById(songId);
    }
}
