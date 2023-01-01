package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.WeatherTypeGenreDto;
import org.springframework.transaction.annotation.Transactional;

public interface WeatherTypeGenreService {
    @Transactional
    void addWeatherTypeGenre(WeatherTypeGenreDto weatherTypeGenreDto, Long weatherTypeId, Long genreId);

    @Transactional
    void deleteWeatherTypeGenreById(Long weatherTypeGenreId);
}
