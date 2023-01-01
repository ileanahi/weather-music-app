package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.WeatherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherTypeRepository extends JpaRepository<WeatherType, Long> {
}
