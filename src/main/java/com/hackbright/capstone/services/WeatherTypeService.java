package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface WeatherTypeService {
    @Transactional
    List<String> addWeatherType(WeatherTypeDto weatherTypeDto);

    @Transactional
    void deleteWeatherTypeById(Long weatherTypeId);

    Optional<WeatherTypeDto> getWeatherTypeByType(String weatherType);
}
