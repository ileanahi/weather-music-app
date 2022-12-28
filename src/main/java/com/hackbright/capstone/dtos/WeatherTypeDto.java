package com.hackbright.capstone.dtos;

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
    private String weatherType;

    public WeatherTypeDto(WeatherType weatherType) {
        if (weatherType.getId() != null) {
            this.id = weatherType.getId();
        }
        if (weatherType.getWeatherType() != null) {
            this.weatherType = weatherType.getWeatherType();
        }
    }
}
