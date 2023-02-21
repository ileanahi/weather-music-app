package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import com.hackbright.capstone.services.WeatherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/weatherTypes")
public class WeatherTypeController {
    @Autowired
    private WeatherTypeService weatherTypeService;

    @PostMapping("/newWeatherType")
    public List<String> addWeatherType(@RequestBody WeatherTypeDto weatherTypeDto) {
        return weatherTypeService.addWeatherType(weatherTypeDto);
    }

    @DeleteMapping("/deleteWeatherType")
    public void deleteWeatherTypeById(@PathVariable Long weatherTypeId) {
        weatherTypeService.deleteWeatherTypeById(weatherTypeId);
    }

    @GetMapping("/{weatherType}")
    public Optional<WeatherTypeDto> getWeatherTypeByType(@PathVariable String weatherType) {
        return weatherTypeService.getWeatherTypeByType(weatherType);
    }
}
