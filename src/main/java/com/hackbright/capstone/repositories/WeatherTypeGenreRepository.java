package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.WeatherTypeGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherTypeGenreRepository extends JpaRepository<WeatherTypeGenre, Long> {
}
