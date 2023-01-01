package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.WeatherTypeGenreDto;
import com.hackbright.capstone.entities.*;
import com.hackbright.capstone.repositories.GenreRepository;
import com.hackbright.capstone.repositories.WeatherTypeGenreRepository;
import com.hackbright.capstone.repositories.WeatherTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WeatherTypeGenreServiceImpl {
    @Autowired
    private WeatherTypeRepository weatherTypeRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private WeatherTypeGenreRepository weatherTypeGenreRepository;

    @Transactional
    public void addWeatherTypeGenre(WeatherTypeGenreDto weatherTypeGenreDto, Long weatherTypeId, Long genreId) {
        Optional<WeatherType> weatherTypeOptional = weatherTypeRepository.findById(weatherTypeId);
        Optional<Genre> genreOptional = genreRepository.findById(genreId);
        WeatherTypeGenre weatherTypeGenre = new WeatherTypeGenre(weatherTypeGenreDto);
        weatherTypeOptional.ifPresent(weatherTypeGenre::setWeatherType);
        genreOptional.ifPresent(weatherTypeGenre::setGenre);
        weatherTypeGenreRepository.saveAndFlush(weatherTypeGenre);
    }

    @Transactional
    public void deleteWeatherTypeGenreById(Long weatherTypeGenreId) {
        Optional<WeatherTypeGenre> weatherTypeGenreOptional = weatherTypeGenreRepository.findById(weatherTypeGenreId);
        weatherTypeGenreOptional.ifPresent(weatherTypeGenre -> weatherTypeGenreRepository.delete(weatherTypeGenre));
    }
}

// Match genres to weather types
// Find genres that match the weather type