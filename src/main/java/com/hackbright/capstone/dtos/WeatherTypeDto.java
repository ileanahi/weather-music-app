package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.entities.WeatherType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherTypeDto implements Serializable {
    private Long id;
    private String type;

    private Genre genre;

    public WeatherTypeDto(WeatherType weatherType) {
        if (weatherType.getId() != null) {
            this.id = weatherType.getId();
        }
        if (weatherType.getType() != null) {
            this.type = weatherType.getType();
        }
        if(weatherType.getGenre() != null){
            this.genre = weatherType.getGenre();
        }
    }
}
