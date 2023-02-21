package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.UserDto;
import com.hackbright.capstone.dtos.WeatherTypeDto;
import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.entities.User;
import com.hackbright.capstone.entities.WeatherType;
import com.hackbright.capstone.repositories.WeatherTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        response.add("New weather type added");
        return response;
    }

    @Override
    @Transactional
    public void deleteWeatherTypeById(Long weatherTypeId) {
        Optional<WeatherType> weatherTypeOptional = weatherTypeRepository.findById(weatherTypeId);
        weatherTypeOptional.ifPresent(weatherType -> weatherTypeRepository.delete(weatherType));
    }

    @Override
    public Optional<WeatherTypeDto> getWeatherTypeByType(String weatherType) {
        Optional<WeatherType> weatherTypeOptional = weatherTypeRepository.findByType(weatherType);
        return weatherTypeOptional.map(WeatherTypeDto::new);
    }
}
