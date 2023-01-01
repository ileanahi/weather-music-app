package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.GenreDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface GenreService {
    @Transactional
    List<String> addGenre(GenreDto genreDto);
}
