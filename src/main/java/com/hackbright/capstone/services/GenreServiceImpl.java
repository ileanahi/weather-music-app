package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.GenreDto;
import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.entities.Song;
import com.hackbright.capstone.repositories.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public void deleteGenreById(Long genreId) {
        Optional<Genre> genreOptional = genreRepository.findById(genreId);
        genreOptional.ifPresent(genre -> genreRepository.delete(genre));
    }
}
