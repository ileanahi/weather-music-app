package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.WeatherTypeGenreDto;
import com.hackbright.capstone.services.WeatherTypeGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/weatherTypeGenres")
public class WeatherTypeGenreController {
    @Autowired
    private WeatherTypeGenreService weatherTypeGenreService;

    @PostMapping("/weatherType/{weatherTypeId}")
    public void addWeatherTypeGenre(@RequestBody WeatherTypeGenreDto weatherTypeGenreDto, @PathVariable Long weatherTypeId, @PathVariable Long genreId) {
        weatherTypeGenreService.addWeatherTypeGenre(weatherTypeGenreDto, weatherTypeId, genreId);
    }

    @DeleteMapping("/{weatherTypeGenreId}")
    public void deleteWeatherTypeGenreById(@PathVariable Long weatherTypeGenreId) {
        weatherTypeGenreService.deleteWeatherTypeGenreById(weatherTypeGenreId);
    }
}
