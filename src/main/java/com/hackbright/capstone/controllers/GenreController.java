package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.GenreDto;
import com.hackbright.capstone.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/newGenre")
    public List<String> addSong(@RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

    @DeleteMapping("/deleteGenre")
    public void deleteGenreById(@PathVariable Long genreId) {
        genreService.deleteGenreById(genreId);
    }
}
