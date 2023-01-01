package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.GenreDto;
import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.repositories.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    @Transactional
    public List<String> addGenre(GenreDto genreDto) {
        List<String> response = new ArrayList<>();
        Genre genre = new Genre(genreDto);
        genreRepository.saveAndFlush(genre);
        response.add("Genre added successfully");
        return response;
    }
}
