package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.WeatherTypeGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherTypeGenreDto implements Serializable {
    private Long id;
    private WeatherTypeDto weatherTypeDto;
    private GenreDto genreDto;

    public WeatherTypeGenreDto(WeatherTypeGenre weatherTypeGenre) {
        if (weatherTypeGenre.getId() != null) {
            this.id = weatherTypeGenre.getId();
        }
    }
}
