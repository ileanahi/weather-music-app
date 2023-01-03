package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.FavoriteSongDto;
import com.hackbright.capstone.services.FavoriteSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/favoriteSongs")
public class FavoriteSongController {
    @Autowired
    private FavoriteSongService favoriteSongService;

    @GetMapping("user/{userId}")
    public List<FavoriteSongDto> getFavoriteSongsByUser(@PathVariable Long userId) {
        return favoriteSongService.getAllFavoriteSongsByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addFavoriteSong(@RequestBody FavoriteSongDto favoriteSongDto, @PathVariable Long userId, @PathVariable Long songId) {
        favoriteSongService.addFavoriteSong(favoriteSongDto, userId, songId);
    }

    @DeleteMapping("/{favoriteSongId}")
    public void deleteFavoriteSongById(@PathVariable Long favoriteSongId) {
        favoriteSongService.deleteFavoriteSongById(favoriteSongId);
    }

    @GetMapping("/{noteId}")
    public Optional<FavoriteSongDto> getFavoriteSongById(@PathVariable Long favoriteSongId) {
        return favoriteSongService.getFavoriteSongById(favoriteSongId);
    }

}
