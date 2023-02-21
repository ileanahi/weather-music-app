package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.entities.WeatherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<WeatherType> findByType(String type);
}
