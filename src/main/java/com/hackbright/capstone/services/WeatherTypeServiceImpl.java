package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import com.hackbright.capstone.entities.WeatherType;
import com.hackbright.capstone.repositories.WeatherTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherTypeServiceImpl implements WeatherTypeService {
    @Autowired
    private WeatherTypeRepository weatherTypeRepository;

    @Override
    @Transactional
    public List<String> addWeatherType(WeatherTypeDto weatherTypeDto) {
        List<String> response = new ArrayList<>();
        WeatherType weatherType = new WeatherType(weatherTypeDto);
        weatherTypeRepository.saveAndFlush(weatherType);
        return response;
    }
}
