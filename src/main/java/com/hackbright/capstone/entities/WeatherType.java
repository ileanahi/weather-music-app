package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WeatherTypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String weatherType;

    public WeatherType(WeatherTypeDto weatherTypeDto) {
        if (weatherTypeDto.getWeatherType() != null) {
            this.weatherType = weatherTypeDto.getWeatherType();
        }
    }
}
