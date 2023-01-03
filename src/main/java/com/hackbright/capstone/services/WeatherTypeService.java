package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WeatherTypeService {
    @Transactional
    List<String> addWeatherType(WeatherTypeDto weatherTypeDto);

    @Transactional
    void deleteWeatherTypeById(Long weatherTypeId);
}
